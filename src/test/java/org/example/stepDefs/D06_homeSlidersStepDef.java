package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef
{

    P03_homePage login = new P03_homePage();


    @Given("user click in first slider")
    public void userClickInFirstSlider() throws InterruptedException {
        login.clickFirstBanner();

    }

    @Then("the Nokia page open")
    public void theProductPageOpen() {
        var expectedUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        Assert.assertEquals(login.getCurrentUrl(),expectedUrl);

    }

    @Given("user click in second slider")
    public void userClickInSecondSlider() throws InterruptedException {
        login.clickSecondBanner();
    }


    @Then("the iphone page open")
    public void theIphonePageOpen() {
        var expectedUrl = "https://demo.nopcommerce.com/iphone-6";

        Assert.assertEquals(login.getCurrentUrl(),expectedUrl);
    }



}
