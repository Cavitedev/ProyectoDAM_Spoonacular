/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */
package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular;

import com.cavitedet.proyectodam_spoonacular.Secrets;

import org.apache.http.Consts;
import org.apache.http.entity.ContentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class ApiInvoker {
    /**
     * Content type "text/plain" with UTF-8 encoding.
     */
    public static final ContentType TEXT_PLAIN_UTF8 = ContentType.create("text/plain", Consts.UTF_8);

    private static final ApiInvoker instance = new ApiInvoker();

    private final Map<String, String> defaultHeaderMap = new HashMap<>();


    public static ApiInvoker getInstance() {
        return instance;
    }


    public static String parameterToString(Object param) {
        if (param == null) {
            return "";
        } else if (param instanceof Collection) {
            StringBuilder b = new StringBuilder();
            for (Object o : (Collection) param) {
                if (b.length() > 0) {
                    b.append(",");
                }
                b.append(o);
            }
            return b.toString();
        } else {
            return String.valueOf(param);
        }
    }

    /*
      Format to {@code Pair} objects.
    */
    public static List<Pair> parameterToPairs(String collectionFormat, String name, Object value) {
        List<Pair> params = new ArrayList<>();

        // preconditions
        if (name == null || name.isEmpty() || value == null) return params;

        Collection valueCollection;
        if (value instanceof Collection) {
            valueCollection = (Collection) value;
        } else {
            params.add(new Pair(name, parameterToString(value)));
            return params;
        }

        if (valueCollection.isEmpty()) {
            return params;
        }

        // get the collection format
        collectionFormat = (collectionFormat == null || collectionFormat.isEmpty() ? "csv" : collectionFormat); // default: csv

        // create the params based on the collection format
        if (collectionFormat.equals("multi")) {
            for (Object item : valueCollection) {
                params.add(new Pair(name, parameterToString(item)));
            }

            return params;
        }

        String delimiter = ",";

        switch (collectionFormat) {
            case "csv":
                delimiter = ",";
                break;
            case "ssv":
                delimiter = " ";
                break;
            case "tsv":
                delimiter = "\t";
                break;
            case "pipes":
                delimiter = "|";
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (Object item : valueCollection) {
            sb.append(delimiter);
            sb.append(parameterToString(item));
        }

        params.add(new Pair(name, sb.substring(1)));

        return params;
    }


    public static String serialize(Object obj) throws ApiException {
        try {
            if (obj != null)
                return JsonUtil.serialize(obj);
            else
                return null;
        } catch (Exception e) {
            throw new ApiException(500, e.getMessage());
        }
    }

    public void addDefaultHeader(String key, String value) {
        defaultHeaderMap.put(key, value);
    }

    public String escapeString(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    public String invokeAPI(String host, String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType) throws ApiException {


        StringBuilder b = new StringBuilder();
        b.append("?");
        if (queryParams != null) {
            for (Pair queryParam : queryParams) {
                if (!queryParam.getName().isEmpty()) {
                    b.append(escapeString(queryParam.getName()));
                    b.append("=");
                    b.append(escapeString(queryParam.getValue()));
                    b.append("&");
                }
            }
        }

        String querystring = b.substring(0, b.length() - 1);
        String url = host + path + querystring;

        HashMap<String, String> headers = new HashMap<>();

        for (String key : headerParams.keySet()) {
            headers.put(key, headerParams.get(key));
        }

        for (String key : defaultHeaderMap.keySet()) {
            if (!headerParams.containsKey(key)) {
                headers.put(key, defaultHeaderMap.get(key));
            }
        }
        headers.put("Accept", "application/json");

        // URL encoded string from form parameters
        String formParamStr = null;

        // for form data
        if ("application/x-www-form-urlencoded".equals(contentType)) {
            StringBuilder formParamBuilder = new StringBuilder();

            // encode the form params
            for (String key : formParams.keySet()) {
                String value = formParams.get(key);
                if (value != null && !"".equals(value.trim())) {
                    if (formParamBuilder.length() > 0) {
                        formParamBuilder.append("&");
                    }
                    try {
                        formParamBuilder.append(URLEncoder.encode(key, "utf8")).append("=").append(URLEncoder.encode(value, "utf8"));
                    } catch (Exception e) {
                        // move on to next
                    }
                }
            }
            formParamStr = formParamBuilder.toString();
        }


        try {
            URL pageUrl = null;


            if ("GET".equals(method)) {


                pageUrl = new URL(url + "&apiKey=" + Secrets.apiKey);


            }
            HttpsURLConnection urlConnection = (HttpsURLConnection) pageUrl.openConnection();

            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("X-Environment", "android");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setSSLSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
            urlConnection.connect();

            int code = urlConnection.getResponseCode();
            String responseString = urlConnection.getResponseMessage();


            if (code == 204) {
                responseString = "";
                return responseString;
            } else if (code >= 200 && code < 300) {
                InputStream contentStream = (InputStream) urlConnection.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(contentStream));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } else {
                if (responseString == null) {
                    responseString = "no data";
                }
            }
            throw new ApiException(code, responseString);
        } catch (IOException e) {
            throw new ApiException(500, e.getMessage());
        }
    }



}
