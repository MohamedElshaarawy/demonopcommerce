package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {


    P03_homePage homePage = new P03_homePage();


    @Given(":user add HTC phone to wish list")
    public void userAddHTCPhoneToWishList() {
        homePage.addHtcToWishList();

    }




    @Then(":message with green background appears and correct text appear")
    public void messageWithGreenBackgroundAppearsAndCorrectTextAppear() {

        SoftAssert softAssert = new SoftAssert();

        var actualColor = homePage.getBarnotificationBackGroundColor();

        softAssert.assertEquals(actualColor,"#4bb07a");

        var actualText = homePage.getBarnotificationText();

        softAssert.assertTrue((actualText).contains("The product has been added to your "),"Assert correct message");

        softAssert.assertAll();


    }

    @Then(":wait for success message to disappear")
    public void waitForSuccessMessageToDisappear() {
        homePage.waitForNoficiationBarToDisappear();
    }


    @Then(":verify Qty is more {int}")
    public void verifyQtyIsMore(int arg0) throws InterruptedException {

        System.out.println("wish list counter" + homePage.getWishListCounter());
        Assert.assertTrue((homePage.getWishListCounter())>arg0);
    }
}


