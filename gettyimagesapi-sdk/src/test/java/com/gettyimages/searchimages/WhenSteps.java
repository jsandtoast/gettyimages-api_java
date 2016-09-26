package com.gettyimages.searchimages;

import com.gettyimages.SdkException;
import com.gettyimages.search.*;
import cucumber.api.java.en.When;
import org.json.JSONObject;

import static org.junit.Assert.fail;

/**
 * When steps for image-search.feature
 */
public class WhenSteps {

    private Context context;

    public WhenSteps() {
        context = Context.getInstance();
    }

    @When("^I configure my search for (.*) images$")
    public void i_configure_my_search_for_an_image_family(String imageFamily) throws Throwable {
        context.setImagesSearch(imageFamily);
    }

    @When("^I specify that I only want to return (.*) with my search results$")
    public void i_specify_that_I_only_want_to_return_a_response_field_with_my_search_results(String responseField) throws Throwable {
        imagesSearch().WithResponseField(responseField);
    }

    @When("^I specify (.*) editorial segment$")
    public void I_specify_an_editorial_segment(EditorialSegment segment) throws Throwable {
        imagesSearch().WithEditorialSegment(segment);
    }

    @When("^I search for (.*)")
    public void i_search_for_a_phrase(String phrase) throws Throwable {
        try {
            String searchResultStr = imagesSearch().WithPhrase(phrase)
                    .ExecuteAsync();
            context.setSearchResult(new JSONObject(searchResultStr));
        } catch (SdkException e) {
            fail("Search is supposed to successfully execute, but instead received: " + e.getLocalizedMessage());
        }
    }

    @When("^I specify a graphical (.*)$")
    public void I_specify_a_graphical_style(GraphicalStyles style) throws Throwable {
        imagesSearch().WithGraphicalStyle(style);
    }

    @When("^I specify I want only embeddable images$")
    public void I_specify_I_want_only_embeddable_images() throws Throwable {
        imagesSearch().WithEmbedContentOnly(true);
    }

    @When("^I specify I want to exclude images containing nudity$")
    public void I_specify_I_want_to_exclude_images_containing_nudity() throws Throwable {
        imagesSearch().WithExcludeNudity(true);
    }

    @When("^I specify a license model (.*)$")
    public void I_specify_a_license_model(String modelStr) throws Throwable {
        LicenseModel model;
        switch(modelStr.toLowerCase()) {
            case "RightsManaged" : {
                model = LicenseModel.RIGHTS_MANAGED;
                break;
            }
            case "RoyaltyFree" : {
                model = LicenseModel.ROYALTY_FREE;
                break;
            }
            default:
                model = LicenseModel.NONE;
                break;
        }
        imagesSearch().WithLicenseModel(model);
    }

    @When("^I specify an orientation (.*)$")
    public void I_specify_an_orientation_value(Orientation orientation) throws Throwable {
        imagesSearch().WithOrientation(orientation);
    }

    private ImagesSearch imagesSearch() {
        return context.getImagesSearch();
    }
}
