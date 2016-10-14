package com.gettyimages.search;

import com.gettyimages.ApiClient;
import com.gettyimages.SdkException;
import com.gettyimages.search.filters.EditorialSegment;

public class EditorialSearchWithSegment
{
    private static String apiKey = "janms687v2zurxrhsmjfh8yy";
    private static String apiSecret = "7ehH8PARubDm8trVkwr9RJuxZp84T5mTsaQzB68deRX6v";
    private static String userName = "jamessantos_api";
    private static String userPassword = "L56PPlRLUrgtUIt";

    public static void main( String[] args )
    {
        ApiClient client = ApiClient.GetApiClientWithResourceOwnerCredentials(apiKey, apiSecret, userName, userPassword);
        String searchTerm = "olympics";

        try {
            ImagesSearch search = client.search()
                .images()
                .editorial()
                .withEditorialSegment(EditorialSegment.SPORT)
                .withPhrase(searchTerm)
                .withPage(10);
            String result = search.executeAsync();
            System.out.print(result);

        } catch (SdkException e) {
            System.out.println("Exception occurred while searching for editorial images: " + e.getLocalizedMessage());
            System.exit(-1);
        }
    }
}
