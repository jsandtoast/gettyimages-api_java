package com.gettyimages.search;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;
import com.gettyimages.search.filters.GraphicalStyles;

public class CreativeSearchWithGraphicalStyle
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
            ImagesSearch search = client.search()
                .images()
                .creative()
                .withGraphicalStyle(GraphicalStyles.PHOTOGRAPHY)
                .withGraphicalStyle(GraphicalStyles.FINE_ART)
                .withPhrase(searchTerm)
                .withPage(10);
            String result = search.executeAsync();
            System.out.print(result);

        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for creative images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }
}
