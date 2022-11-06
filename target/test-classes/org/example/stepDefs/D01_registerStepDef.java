package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.example.pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }


    @When("user select gender type")
    public void userSelectGenderType() {
        register.maleRadio().click();
    }


    @Given("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.firstNametxt().sendKeys(arg0);
        register.lastNametxt().sendKeys(arg1);
    }

    @Given("user enter date of birth")
    public void userEnterDateOfBirth() {
         register.dateOfBirthDayDropDown().sendKeys("8");

         Select selectDate = new Select(register.dateOfBirthMonthDropDown());
         selectDate.selectByIndex(1);
         //register.dateOfBirthMonthDropDown().sendKeys("January");
         register.dateOfBirthYearDropDown().sendKeys("2000");
    }

    @Given("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
register.emailTextBox().sendKeys(arg0);
    }

    @Given("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.passwordTextBox().sendKeys(arg0);
        register.confirmPasswordTextBox().sendKeys(arg1);
    }

    @Given("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerBtn().click();
    }

    @Given("success message is displayed")
    public void successMessageIsDisplayed() {
        var actual = register.getResultLbltext();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actual.contains("Your registration completed"),"message");

        var actualColor = register.getResultLblColor();
        softAssert.assertEquals(actualColor,"#4cb17c");

        softAssert.assertAll();
    }



}
