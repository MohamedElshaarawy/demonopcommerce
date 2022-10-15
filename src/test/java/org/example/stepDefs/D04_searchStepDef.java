package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {

    P03_homePage homePage = new P03_homePage();


    @Given("user search by {string}")
    public void userSearchBy(String ProductName) {
        homePage.searchTextBox().sendKeys(ProductName);
    }


    @And("user Click search button")
    public void userClickSearchButton() throws InterruptedException {
        homePage.searchButton().click();
        Thread.sleep(5000);
    }

    @Then("user see search page with searched {string}")
    public void userSeeSearchPageWithSearchedProductName(String ProductName) {

        SoftAssert softAssert  = new SoftAssert();
        softAssert.assertTrue(homePage.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="),"Assert URL is correct");

        softAssert.assertTrue(homePage.resultsContainCorrectProduct(ProductName),"Assert all product contain word" + ProductName);

        softAssert.assertAll();
    }


    @Then("user click on product in search result")
    public void userClickOnProductInSearchResult() {
        homePage.getProductItem().click();
    }


    @Then("user see the {string} in product page")
    public void userSeeTheInProductPage(String SKU) {

        Assert.assertTrue(homePage.getProductSku().contains(SKU),"Assert SKU is correct");
    }


}
