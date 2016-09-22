package com.gettyimages;

import cucumber.api.java.en.Given;

/**
 * Created by jsantos on 9/22/16.
 */
public class StepDefinitions {

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        System.out.println("This is a test");
    }
}
