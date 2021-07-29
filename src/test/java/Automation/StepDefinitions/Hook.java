package Automation.StepDefinitions;

import Automation.Utilities.Driver;

import io.cucumber.java.After;

public class Hook {

    @After
    public void teardown() {
        Driver.closeDriver();
    }
}
