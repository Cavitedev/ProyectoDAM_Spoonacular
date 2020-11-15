package com.cavitedet.proyectodam_spooncolar.spooncolar;


import com.cavitedet.proyectodam_spooncolar.domain.spooncolar.ingredient.Ingredients;
import com.cavitedet.proyectodam_spooncolar.infrastructure.spooncolar.ApiException;
import com.cavitedet.proyectodam_spooncolar.infrastructure.spooncolar.DefaultApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

@RunWith(JUnit4.class)
public class SearchRecipesApiTest {


    @Test
    public void testApi2() {
        DefaultApi apiInstance = new DefaultApi();

//        apiInstance.addHeader("Authorization" ,"Basic " + Secrets.base64ApiKey());
        String query = "banana";
        BigDecimal number = new BigDecimal(2);
        try {
            Ingredients result = apiInstance.ingredientSearch(query, null, null, null,
                    null, null, null, null,
                    null, null, "calories", "desc", null,
                    number);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getRecipeInformation");
            e.printStackTrace();
        }


    }
}
