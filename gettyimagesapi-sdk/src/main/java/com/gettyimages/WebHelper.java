package com.gettyimages;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class WebHelper {
    protected String baseUrl;
    protected Credentials credentials;

    public WebHelper(Credentials credentials, String baseUrl) {
        this.credentials = credentials;
        this.baseUrl = baseUrl;
    }

    public String Get(Map queryParams, String path) throws SdkException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpGet httpGet = RetrieveGetRequest(queryParams, path);
            HttpResponse response = httpClient.execute(httpGet);
            return GetResponse(response);
        } catch (IOException ex) {
            //TODO what to return here?
        }
        return "";
    }

    public String PostQuery(Map<String, String> queryParams, String path) throws SdkException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost httpPost = RetrievePostRequest(queryParams, path);
            HttpResponse response = httpClient.execute(httpPost);
            return GetResponse(response);
        } catch (MalformedURLException ex) {
            String s = ex.toString();
        } catch (IOException ex) {
            String s = ex.toString();
        }
        return "";
    }

    private HttpPost RetrievePostRequest(Map<String, String> queryParams, String path) throws MalformedURLException, SdkException {
        String query = BuildQuery(queryParams);
        URL url = new URL(baseUrl + path + "?" + query);
        HttpPost httpPost = new HttpPost(url.toString());
        addHeaders(httpPost);
        return httpPost;
    }

    private void addHeaders(HttpRequest request) throws SdkException {
        switch (credentials.CredentialType) {
            case ApiKey: {
                request.addHeader("Api-Key", credentials.ApiKey);
                break;
            }
            case ClientCredentials:
            case ResourceOwner: {
                request.addHeader("Api-Key", credentials.ApiKey);
                request.addHeader("Authorization", "Bearer " + credentials.GetAccessToken().getTokenString());
                break;
            }
        }
        request.addHeader("User-Agent", getUserAgent());
    }

    private String getUserAgent()
    {
        String httpAgentString = "";
        String httpAgent = System.getProperty("http.agent");
        if (httpAgent != null) {
            httpAgentString = httpAgent.replace(")", "").replace(" (", "; ");
        }
        else {
            String osName = System.getProperty("os.name");
            String osArch = System.getProperty("os.arch");
            String javaVersion = System.getProperty("java.version");
            httpAgentString = String.format("%s; %s; Java %s", osName, osArch, javaVersion);
        }

        String userAgentString = String.format("GettyApiSdk/%s (%s)", ApiClient.Version, httpAgentString);
        return userAgentString;
    }

    private String BuildQuery(Map<?, ?> queryParams) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<?, ?> entry : queryParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }

        return sb.toString();
    }

    private String GetResponse(HttpResponse response) throws IOException {
        HttpEntity responseEntity = response.getEntity();
        String content = EntityUtils.toString(responseEntity);
        return content;
    }

    private HttpGet RetrieveGetRequest(Map queryParams, String path) throws MalformedURLException, SdkException {
        String query = BuildQuery(queryParams);
        URL url = new URL(baseUrl + path + "?" + query);
        HttpGet httpGet = new HttpGet(url.toString());
        addHeaders(httpGet);
        return httpGet;
    }

    private static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
