package com.gettyimages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Shared test class, primarily used for authentication calls.
 */
public class Context {

    private static final String GETTYIMAGESAPI_ENV_NAME_APIKEY = "GettyImagesApi_ApiKey";
    private static final String GETTYIMAGESAPI_ENV_NAME_APISECRET = "GettyImagesApi_ApiSecret";
    private static final String GETTYIMAGESAPI_ENV_NAME_USERNAME = "GettyImagesApi_UserName";
    private static final String GETTYIMAGESAPI_ENV_NAME_USERPASSWORD = "GettyImagesApi_UserPassword";
    private static final String BASEURL = "https://api.gettyimages.com";
    private static Map<String, String> ApiProperties;

    static {
        ApiProperties = new HashMap<>();
        GetEnvironmentVariables();
    }

    public static Token GetAccessToken() throws SdkException {
        Credentials creds = Credentials.GetInstance(
                GetProp(GETTYIMAGESAPI_ENV_NAME_APIKEY),
                GetProp(GETTYIMAGESAPI_ENV_NAME_APISECRET),
                GetProp(GETTYIMAGESAPI_ENV_NAME_USERNAME),
                GetProp(GETTYIMAGESAPI_ENV_NAME_USERPASSWORD),
                BASEURL
        );
        return creds.GetAccessToken();
    }

    public static Token GetAccessTokenViaRefreshToken(String refreshToken) throws SdkException {
        Credentials creds = Credentials.GetInstance(
                GetProp(GETTYIMAGESAPI_ENV_NAME_APIKEY),
                GetProp(GETTYIMAGESAPI_ENV_NAME_APISECRET),
                refreshToken,
                BASEURL
        );
        return creds.GetAccessToken();
    }

    private static String GetProp(String gettyimagesapiEnvName) {
        return ApiProperties.get(gettyimagesapiEnvName);
    }

    public static boolean ApiKeyExists() {
        return ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_APIKEY);
    }

    public static boolean ApiSecretExists() {
        return ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_APISECRET);
    }

    public static boolean UsernameExists() {
        return ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_USERNAME);
    }

    public static boolean UserPasswordExists() {
        return ApiProperties.containsKey(GETTYIMAGESAPI_ENV_NAME_USERPASSWORD);
    }

    private static void GetEnvironmentVariables() {
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
}
