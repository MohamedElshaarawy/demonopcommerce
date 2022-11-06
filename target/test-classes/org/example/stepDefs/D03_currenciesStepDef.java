package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D03_currenciesStepDef {

    P03_homePage homePage = new P03_homePage();

    @Given("user select euro currency from dropdown list")
    public void userSelectEuroCurrencyFromDropdownList() {
        homePage.selectCurrency("Euro");
    }



    @Then("the products in home page are shown with Euro Symbol \\(€)")
    public void theProductsInHomePageAreShownWithEuroSymbol() {
        Assert.assertTrue(homePage.arePricesCurrncySymboleCorrect("€"),"Assert prices in Euro");
    }


}
