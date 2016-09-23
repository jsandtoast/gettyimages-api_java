package com.gettyimages;

import com.gettyimages.search.ICreativeImagesSearch;
import com.gettyimages.search.IEditorialImagesSearch;
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

    private ICreativeImagesSearch creativeImagesSearch;
    private IEditorialImagesSearch editorialImagesSearch;
    private boolean isCreativeSearch;
    private String searchResult;

    @When("^I configure my search for (.*) images$")
    public void i_configure_my_search_for_an_image_family(String imageFamily) throws Throwable {
        switch (imageFamily.toLowerCase()) {
            case "creative": {
                creativeImagesSearch = Context.GetApiClientWithResourceOwnerCredentials()
                        .Search()
                        .Images()
                        .Creative();
                isCreativeSearch = true;
            }
            case "editorial": {
                editorialImagesSearch = Context.GetApiClientWithResourceOwnerCredentials()
                        .Search()
                        .Images()
                        .Editorial();
                isCreativeSearch = false;
            }
        }
    }

    @When("^I search for (.*)")
    public void i_search_for_a_phrase(String phrase) throws Throwable {
        try {
            if(isCreativeSearch) {
                creativeImagesSearch = creativeImagesSearch.WithPhrase(phrase);
                searchResult = creativeImagesSearch.ExecuteAsync();
            }
            else {
                editorialImagesSearch = editorialImagesSearch.WithPhrase(phrase);
                searchResult = editorialImagesSearch.ExecuteAsync();
            }
        } catch (SdkException e) {
            fail("Search is supposed to successfully execute, but instead received: " + e.getLocalizedMessage());
        }
    }

    @Then("^I get a response back that has my images$")
    public void i_get_a_response_back_that_has_my_images() throws Throwable {
        assertNotNull(searchResult);
        JSONObject resultJson = (JSONObject) new JSONObject(searchResult);
        long resultCount = resultJson.getLong("result_count");
        JSONArray images = resultJson.getJSONArray("images");
        assertNotNull(resultCount);
        if(resultCount > 0) {
            assertTrue(images.length() > 0);
        }
    }
}
