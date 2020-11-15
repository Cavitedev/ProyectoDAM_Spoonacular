/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */
package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular;

import com.cavitedet.proyectodam_spoonacular.Secrets;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiInvoker {
    /**
     * Content type "text/plain" with UTF-8 encoding.
     */
    public static final ContentType TEXT_PLAIN_UTF8 = ContentType.create("text/plain", Consts.UTF_8);
    private static final ApiInvoker INSTANCE = new ApiInvoker();
    private final Map<String, String> defaultHeaderMap = new HashMap<>();
    private HttpClient client = null;

    public ApiInvoker() {
    }

    /**
     * ISO 8601 date time format.
     *
     * @see "https://en.wikipedia.org/wiki/ISO_8601"
     */


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

    public static ApiInvoker getInstance() {
        return INSTANCE;
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
        HttpClient client = getClient();

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

        HttpResponse response = null;
        try {
            if ("GET".equals(method)) {
                HttpGet get = new HttpGet(url + "&apiKey=" + Secrets.apiKey);
                get.addHeader("Accept", "application/json");
                for (String key : headers.keySet()) {
                    get.setHeader(key, headers.get(key));
                }
                response = client.execute(get);
            } else if ("POST".equals(method)) {
                HttpPost post = new HttpPost(url);
                if (formParamStr != null) {
                    post.setHeader("Content-Type", contentType);
                    post.setEntity(new StringEntity(formParamStr, "UTF-8"));
                } else if (body != null) {
                    if (body instanceof HttpEntity) {
                        // this is for file uploading
                        post.setEntity((HttpEntity) body);
                    } else {
                        post.setHeader("Content-Type", contentType);
                        post.setEntity(new StringEntity(serialize(body), "UTF-8"));
                    }
                }
                for (String key : headers.keySet()) {
                    post.setHeader(key, headers.get(key));
                }
                response = client.execute(post);
            } else if ("PUT".equals(method)) {
                HttpPut put = new HttpPut(url);
                if (formParamStr != null) {
                    put.setHeader("Content-Type", contentType);
                    put.setEntity(new StringEntity(formParamStr, "UTF-8"));
                } else if (body != null) {
                    put.setHeader("Content-Type", contentType);
                    put.setEntity(new StringEntity(serialize(body), "UTF-8"));
                }
                for (String key : headers.keySet()) {
                    put.setHeader(key, headers.get(key));
                }
                response = client.execute(put);
            } else if ("DELETE".equals(method)) {
                HttpDelete delete = new HttpDelete(url);
                for (String key : headers.keySet()) {
                    delete.setHeader(key, headers.get(key));
                }
                response = client.execute(delete);
            } else if ("PATCH".equals(method)) {
                HttpPatch patch = new HttpPatch(url);
                if (formParamStr != null) {
                    patch.setHeader("Content-Type", contentType);
                    patch.setEntity(new StringEntity(formParamStr, "UTF-8"));
                } else if (body != null) {
                    patch.setHeader("Content-Type", contentType);
                    patch.setEntity(new StringEntity(serialize(body), "UTF-8"));
                }
                for (String key : headers.keySet()) {
                    patch.setHeader(key, headers.get(key));
                }
                response = client.execute(patch);
            }

            int code = response.getStatusLine().getStatusCode();
            String responseString = null;
            if (code == 204) {
                responseString = "";
                return responseString;
            } else if (code >= 200 && code < 300) {
                if (response.getEntity() != null) {
                    HttpEntity resEntity = response.getEntity();
                    responseString = EntityUtils.toString(resEntity);
                }
                return responseString;
            } else {
                if (response.getEntity() != null) {
                    HttpEntity resEntity = response.getEntity();
                    responseString = EntityUtils.toString(resEntity);
                } else
                    responseString = "no data";
            }
            throw new ApiException(code, responseString);
        } catch (IOException e) {
            throw new ApiException(500, e.getMessage());
        }
    }

    private HttpClient getClient() {
        if (client == null) {

            client = HttpClientBuilder.create().build();

        }
        return client;
    }


}
