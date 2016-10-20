package com.gettyimages.downloadimages;

import cucumber.api.java.en.When;

/**
 * Created by jsantos on 10/18/16.
 */
public class WhenSteps {

    private Context context;

    public WhenSteps() {
        context = Context.getInstance();
    }

    @When("^I request for any image to be downloaded$")
    public void i_request_for_any_image_to_be_downloaded() throws Throwable {
        context.downloadImage();
    }
}
