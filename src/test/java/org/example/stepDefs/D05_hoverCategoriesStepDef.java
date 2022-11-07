package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef

{

    P03_homePage homePage = new P03_homePage();

    @Given("user hover on random category")
    public void userHoverOnRandomCategory() {
        homePage.getRandomfromCategories(homePage.getCategories());
        homePage.hooverSelectedCategory();

}

    @And("user select random subcategory")
    public void userSelectRandomSubcategory() throws InterruptedException {
        homePage.clickRandomSubCategory();
    }


    @Then("assert the page title is same like subcatgory or category")
    public void assertThePageTitleIsSameLikeSubcatgory() {
    var expectedSubCategory = homePage.getSelectedSubCategoryText();
        Assert.assertEquals(homePage.getPageTitle(),expectedSubCategory,"assert selected category open page with correct title");
    }
}
