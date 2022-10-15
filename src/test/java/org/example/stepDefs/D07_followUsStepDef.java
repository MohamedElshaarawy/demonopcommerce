package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D07_followUsStepDef {

    P03_homePage homePage = new P03_homePage();

    @Given("user click facebook link")
    public void userClickFacebookLink() {
        homePage.clickFacebookLink();
    }


    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) throws InterruptedException {
        var expectedUrl = arg0;
        homePage.goNextTab();
        Assert.assertEquals(homePage.getCurrentUrl(),expectedUrl);

    }

    @Given("user click twitter link")
    public void userClickTwitterLink() {
        homePage.clickTwitterLink();
    }

    @Given("user click youtube link")
    public void userClickYoutubeLink() {
        homePage.clickYoutubeLink();
    }

    @Given("user click rss link")
    public void userClickRssLink() {
        homePage.clickRssLink();
    }


}
