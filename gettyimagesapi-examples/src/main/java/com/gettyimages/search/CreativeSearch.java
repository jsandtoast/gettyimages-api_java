package com.gettyimages.search;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;

public class CreativeSearch
{
    private static String apiKey = "API Key";
    private static String apiSecret = "API Secret";
    private static String userName = "";
    private static String userPassword = "";

    public static void main( String[] args )
    {
        ApiClient client = ApiClient.GetApiClientWithResourceOwnerCredentials(apiKey, apiSecret, userName, userPassword);
        String searchTerm = "cat";

        try {
            ImagesSearch search = client.Search()
                .Images()
                .Creative()
                .WithPhrase(searchTerm)
                .WithPage(10);
            String result = search.ExecuteAsync();
            System.out.print(result);

        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }
}
