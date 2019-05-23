package Testrunner;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ResourceConstants;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;


public class RESTAPI_Test {
    String token_value;
    private List<Integer> year_list;
    private List<String> email_list;

    @BeforeTest
    public void Base_uri() {


        if (ResourceConstants.BASE_URI != null) {
            RestAssured.baseURI = ResourceConstants.BASE_URI;
        } else {
            throw new RuntimeException("Base_uri is empty. Please check.");
        }
    }

    @Test
    public void Register_tokencheck() {
        Response register = given().
                contentType("application/json").
                body(ResourceConstants.POST_REQUEST_INPUT).when().post(ResourceConstants.REGISTER_SUCCESS_REQUEST).then()
                .statusCode(ResourceConstants.STATUS_CODE).extract().response();

        token_value = register.jsonPath().get("token");

        assertThat(token_value.toString(), notNullValue());
        System.out.println("Token_Value is : " + token_value);
    }


    @Test
    public void Get_Resource_List() {
        Response register = given().
                contentType("application/json")
                .when().get(ResourceConstants.GET_RESOURCE_LIST_REQUEST).then()
                .statusCode(ResourceConstants.STATUS_CODE).extract().response();

        year_list = register.jsonPath().getList("data.year");
        assertThat(year_list.size(), notNullValue());
        for (Integer years : year_list) {
            System.out.println("Year_value is : " + years);
        }
    }

    @Test
    public void Get_delayed_response() {
        Response register = given().
                contentType("application/json").queryParam("delay", "3")
                .when().get(ResourceConstants.DELAYED_RESPONSE).then()
                .statusCode(ResourceConstants.STATUS_CODE).extract().response();

        email_list = register.jsonPath().getList("data.email");
        assertThat(email_list.size(), notNullValue());
        String emails = String.join(",", email_list);
        System.out.println("Email values are: " + emails);
    }
}