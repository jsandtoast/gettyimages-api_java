package com.gettyimages;

import com.gettyimages.search.ImagesSearch;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Implements image-search.feature
 */
public class ImageSearchContext {

    private ImagesSearch imagesSearch;
    private JSONObject searchResult;
    private long resultCount;
    private JSONArray resultImages;

    @When("^I configure my search for (.*) images$")
    public void i_configure_my_search_for_an_image_family(String imageFamily) throws Throwable {
        ImageSearchFactory factory = new ImageSearchFactory(); //TODO try ImageSearchFactory.createImageSearchController or ImageSearchFactory.GetInstance().createImageSearchController() instead
        imagesSearch = factory.createImageSearchController(imageFamily);
    }

    @When("^I search for (.*)")
    public void i_search_for_a_phrase(String phrase) throws Throwable {
        try {
            String searchResultStr = imagesSearch.WithPhrase(phrase)
                    .ExecuteAsync();
            searchResult = new JSONObject(searchResultStr);
        } catch (SdkException e) {
            fail("Search is supposed to successfully execute, but instead received: " + e.getLocalizedMessage());
        }
    }

    @Then("^I get a response back that has my images$")
    public void i_get_a_response_back_that_has_my_images() throws Throwable {
        assertNotNull(searchResult);
        resultCount = searchResult.getLong("result_count");
        resultImages = searchResult.getJSONArray("images");
        assertNotNull("Expected response to include a result count", resultCount);
        if(resultCount > 0) {
            assertTrue("Expected image count to b greater than zero", resultImages.length() > 0);
        }
    }
}
