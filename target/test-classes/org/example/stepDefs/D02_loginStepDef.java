package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

     P02_login login = new P02_login();


     @Given("user go to login page")
     public void goLoginrPage() {
          login.loginlink().click();
     }

     @Given("user login with {string} and {string}")
     public void userLoginWithAnd(String arg0, String arg1) {
          login.emailTextBox().sendKeys(arg0);
          login.passwordTextBox().sendKeys(arg1);
     }

     @Given("user press on login button")
     public void userPressOnLoginButton() {
          login.loginButton().click();
     }

     @Given("user could not login to the system")
     public void userCouldNotLoginToTheSystem() {
          var actualErrorMessage = login.errorMessage().getText();
          SoftAssert softAssert = new SoftAssert();
          softAssert.assertTrue(actualErrorMessage.contains("Login was unsuccessful"), "text assertion failed");
          var actualColor = login.getErrorMessageColor();
          softAssert.assertEquals(actualColor, "#e4434b");

          softAssert.assertAll();
     }

     @Then("user login to the system successfully")
     public void userLoginToTheSystemSuccessfully() {
          var actualUrl = login.getUrl();
          SoftAssert softAssert = new SoftAssert();
          softAssert.assertEquals(actualUrl, "https://demo.nopcommerce.com/", "Assert Correct URL");

          softAssert.assertTrue(login.myAccountButtonDisplayed(), "Assert my Account Button Exist");

          softAssert.assertAll();
     }
}
