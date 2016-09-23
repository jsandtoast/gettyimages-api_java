package com.gettyimages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Implements authentication.feature
 */
public class AuthenticationContext {

    private Token accessToken;
    private String refreshToken;

    @When("^I ask the sdk for an authentication token$")
    public void i_ask_the_sdk_for_an_authentication_token() throws Throwable {
        accessToken = SharedContext.GetAccessToken();
    }

    @Then("^a token is returned$")
    public void a_token_is_returned() throws Throwable {
        assertTrue("Access token should be returned",
                accessToken.getTokenString() != null && accessToken.getTokenString().length() > 0);
    }

    @Given("^a refresh token$")
    public void a_refresh_token() throws Throwable {
        refreshToken = SharedContext.GetAccessToken().getRefreshTokenString();
        assertTrue("Refresh token should exist",
                refreshToken != null && refreshToken.length() > 0);
    }

    @When("^I request an access token$")
    public void i_request_an_access_token() throws Throwable {
        accessToken = SharedContext.GetAccessTokenViaRefreshToken(refreshToken);
    }

    @Then("^an access token is returned$")
    public void an_access_token_is_returned() throws Throwable {
        assertTrue("Access token should be returned",
                accessToken.getTokenString() != null && accessToken.getTokenString().length() > 0);
    }

}
