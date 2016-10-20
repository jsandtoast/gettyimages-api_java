package com.gettyimages.downloadimages;

import cucumber.api.java.en.Then;
import org.json.JSONObject;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jsantos on 10/20/16.
 */
public class ThenClass {

    private Context context;

    public ThenClass() {
        context = Context.getInstance();
    }

    @Then("^the url for the image is returned$")
    public void the_url_for_the_image_is_returned() throws Throwable {
        JSONObject result = context.getDownloadResult();
        assertNotNull(result);
        assertNotNull(result.getString("uri"));
    }
}
