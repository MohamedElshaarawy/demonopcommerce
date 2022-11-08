package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class P02_login {

    public WebElement loginlink()
    {
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement emailTextBox()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordTextBox()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    // login-button

    public WebElement loginButton()
    {
        return Hooks.driver.findElement(By.className("login-button"));
    }
//class="ico-account"

    public WebElement myAccountLink()
    {
    return Hooks.driver.findElement(By.className("ico-account"));
    }

    //class="validation-summary-errors"

    public WebElement errorMessage()
    {
        return Hooks.driver.findElement(By.className("validation-summary-errors"));
    }

    public  String getErrorMessageColor()
    {
        return  Color.fromString(errorMessage().getCssValue("color")).asHex();

    }

    public  String getErrorMessageText()
    {
        return  errorMessage().getText();
    }


    public  String getUrl(){

        return Hooks.driver.getCurrentUrl();
    }

    public Boolean myAccountButtonDisplayed(){

        return myAccountLink().isDisplayed();
    }

}
