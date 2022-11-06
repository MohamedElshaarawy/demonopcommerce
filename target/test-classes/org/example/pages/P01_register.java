package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;



public class P01_register {
    public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }


    public WebElement maleRadio()
    {
        return Hooks.driver.findElement(By.id("gender-male"));
    }


    public WebElement firstNametxt()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastNametxt()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    // select[name="DateOfBirthDay"]

    public WebElement dateOfBirthDayDropDown()
    {
        return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
    }

    public WebElement dateOfBirthMonthDropDown()
    {
        return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
    }


    public WebElement dateOfBirthYearDropDown()
    {
        return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
    }

//

    public WebElement emailTextBox()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }


    //Password

    public WebElement passwordTextBox()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmPasswordTextBox()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    //register-button
    public WebElement registerBtn()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }


    //https://demo.nopcommerce.com/registerresult/1?returnUrl=/

    //[class="result"]

    public WebElement resultLbl()
    {
        return Hooks.driver.findElement(By.className("result"));
    }

    public String  getResultLbltext()
    {
        return resultLbl().getText();
    }

    public String  getResultLblColor()
    {
        return Color.fromString(resultLbl().getCssValue("color")).asHex();

    }


















}
