package com.gettyimages;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by jsantos on 9/22/16.
 */
public class AuthenticationContext {

    private Map<String, String> ApiProperties;
    private static String GETTYIMAGESAPI_ENV_NAME_APIKEY = "GettyImagesApi_ApiKey";
    private static String GETTYIMAGESAPI_ENV_NAME_APISECRET = "GettyImagesApi_ApiSecret";
    private static String GETTYIMAGESAPI_ENV_NAME_USERNAME = "GettyImagesApi_UserName";
    private static String GETTYIMAGESAPI_ENV_NAME_USERPASSWORD = "GettyImagesApi_UserPassword";
    private static String BASEURL = "https://api.gettyimages.com";
    private Token accessToken;

    public AuthenticationContext() {
        ApiProperties = new HashMap<String, String>();
        GetEnvironmentVariables();
    }

    private void GetEnvironmentVariables() {
        List<String> environmentVariables = new ArrayList<String>() {{
            add(GETTYIMAGESAPI_ENV_NAME_APIKEY);
            add(GETTYIMAGESAPI_ENV_NAME_APISECRET);
            add(GETTYIMAGESAPI_ENV_NAME_USERNAME);
            add(GETTYIMAGESAPI_ENV_NAME_USERPASSWORD);
        }};
        for (String key : environmentVariables) {
            String val;
            val = System.getenv(key);
            if (val == null || val.length() == 0) {
                fail("Environment variable does not exist: " + key);
            }
            ApiProperties.put(key, val);
        }
    }

    @Given("^I have an apikey$")
    public void i_have_an_apikey() throws Throwable {
        assertTrue(ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_APIKEY));
    }

    @Given("^an apisecret$")
    public void an_apisecret() throws Throwable {
        assertTrue(ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_APISECRET));
    }

    @Given("^a username$")
    public void a_username() throws Throwable {
        assertTrue(ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_USERNAME));
    }

    @Given("^a password$")
    public void a_password() throws Throwable {
        assertTrue(ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_USERPASSWORD));
    }

    @When("^I ask the sdk for an authentication token$")
    public void i_ask_the_sdk_for_an_authentication_token() throws Throwable {
        Credentials creds = Credentials.GetInstance(
                GetProp(GETTYIMAGESAPI_ENV_NAME_APIKEY),
                GetProp(GETTYIMAGESAPI_ENV_NAME_APISECRET),
                GetProp(GETTYIMAGESAPI_ENV_NAME_USERNAME),
                GetProp(GETTYIMAGESAPI_ENV_NAME_USERPASSWORD),
                BASEURL
        );
        accessToken = creds.GetAccessToken();
    }

    private String GetProp(String gettyimagesapiEnvName) {
        return ApiProperties.get(gettyimagesapiEnvName);
    }

    @Then("^a token is returned$")
    public void a_token_is_returned() throws Throwable {
        Assert.assertNotNull(accessToken);
        Assert.assertTrue(accessToken.TokenString != null && accessToken.TokenString.length() > 0);
    }

    @Given("^a refresh token$")
    public void a_refresh_token() throws Throwable {
        throw new PendingException();
    }

    @When("^I request an access token$")
    public void i_request_an_access_token() throws Throwable {
        throw new PendingException();
    }

    @Then("^an access token is returned$")
    public void an_access_token_is_returned() throws Throwable {
        throw new PendingException();
    }

}
