package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P03_homePage {

    int category;
    String selectedSubCategory;
    int subCategories;
    public List<WebElement> getPrices()
    {
        return Hooks.driver.findElements(By.cssSelector("span.price"));
    }

    public void selectCurrency(String currency)
    {
        Select select = new Select(Hooks.driver.findElement(By.id("customerCurrency")));
        select.selectByVisibleText(currency);
    }

    public boolean arePricesCurrncySymboleCorrect(String selectedCurrency)
    {

        Boolean b = false;

        for ( int i = 0;i<getPrices().size();i++)
        {
           if(getPrices().get(i).getText().startsWith("€")) {
               b = true;

           }
           else
           {
               b = false;
               break;
           }

        }
        return b;
    }


    public  WebElement searchTextBox()
    {
        return Hooks.driver.findElement(By.id("small-searchterms"));

    }

    public void searchFor(String string)
    {
        searchTextBox().sendKeys(string);
    }


    public WebElement searchButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button.search-box-button"));
    }


    public String getCurrentUrl(){

        return Hooks.driver.getCurrentUrl();
    }


    public List<WebElement> getProductSearchResult(){
        return Hooks.driver.findElements(By.cssSelector("div.details > h2 > a"));
    }



    public boolean resultsContainCorrectProduct(String productName)
    {

        Boolean b = false;

        for ( int i = 0;i<getProductSearchResult().size();i++)
        {
            if(getProductSearchResult().get(i).getText().toLowerCase().contains(productName)) {
                b = true;

            }
            else
            {
                b = false;
                break;
            }

        }
        return b;
    }

    public WebElement getProductItem(){
        return Hooks.driver.findElement(By.cssSelector("div.picture > a"));
    }

    public String getProductSku()
    {
        return Hooks.driver.findElement(By.cssSelector("span[id^=sku-]")).getText();
    }

    public List<WebElement> getCategories(){
        System.out.println(Hooks.driver.findElements(By.cssSelector("ul.top-menu.notmobile > li > a")).size());

        return  Hooks.driver.findElements(By.cssSelector("ul.top-menu.notmobile > li > a"));

    }

    public WebElement getRandomfromCategories(List<WebElement> Categories)
    {
    int min = 0;
    int max = 2;
    int selectedCategory = (int)Math.floor((Math.random()*(max-min+1))+min);
        System.out.println("selectedCategory : " + selectedCategory);
    this.category = selectedCategory + 1;
        System.out.println("Selected Category : "+ getCategories().get(selectedCategory).getText() );
      return   getCategories().get(selectedCategory);
    }

//    public List<WebElement> getSubCategories(){
//        return getCategories().get(this.category-1).findElements();
//        return null;
//    }


//    public int getRandomfromSubCategories(List<WebElement> subCategories)
//    {
//    int min = 0;
//    int max = 2;
//    int selectedSubCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
//    this.subCategories = selectedSubCategory + 1;
//      return   selectedSubCategory + 1;
//    }

    public void hooverSelectedCategory()
    {
       Actions actions = new Actions(Hooks.driver);
       WebElement selectedElement = Hooks.driver.findElement(By.cssSelector("ul.top-menu.notmobile > li:nth-child("+this.category+") > a"));
       actions.moveToElement(selectedElement).perform();

    }


    public String getSelectedSubCategoryText(){
        return this.selectedSubCategory.toLowerCase().trim();
    }

    public void clickRandomSubCategory()
    {
       List<WebElement> subCategories = Hooks.driver.findElements(By.cssSelector("ul.top-menu.notmobile > li:nth-child("+this.category+") > ul > li >a"));
        System.out.println("subCategories : "+subCategories.size());
        System.out.println("sub1 : "+subCategories.get(0).getText());
        System.out.println("sub2 : "+subCategories.get(1).getText());
        System.out.println("sub3 : "+subCategories.get(2).getText());

        int min = 0;
        int max = 2;
        int selectedSubCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.subCategories = selectedSubCategory + 1;

        System.out.println("subCategorys : "+subCategories.get(selectedSubCategory).getText());
        this.selectedSubCategory =subCategories.get(selectedSubCategory).getText();

        subCategories.get(selectedSubCategory).click();




    }
     public String getPageTitle()
     {
         WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(5));
         WebElement pageTitle = Hooks.driver.findElement(By.cssSelector("div.page-title > h1"));
         wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText().toLowerCase().trim();
     }

//    public void clickRandomSubCategory(List<WebElement> subCategories) throws InterruptedException {
//
//        if(subCategories.isEmpty())
//        {
//            Hooks.driver.findElement(By.cssSelector("ul.top-menu.notmobile > li:nth-child("+this.category+") > a")).click();
//        }
//        else
//        {
//            this.subCategories = getRandomfromCategories(getSubCategories());
//            WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
//            WebElement sub = Hooks.driver.findElement(By.cssSelector("ul.top-menu.notmobile > li:nth-child("+this.category +") > ul > li:nth-child("
//                    +this.subCategories+") > a"));
//            System.out.println("selected Sub "+ this.subCategories + "selected main " + category);
//            wait.until(ExpectedConditions.elementToBeClickable(sub));
//            sub.click();
//
//
//
//        }
//
//    }




    public void clickFirstBanner() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

        js.executeScript("document.querySelector(\"#nivo-slider > a:nth-child(1)\").click()");
        Thread.sleep(5000);
    }


    public void clickSecondBanner() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

        js.executeScript("document.querySelector(\"#nivo-slider > a:nth-child(2)\").click()");
        Thread.sleep(5000);
    }

    public void clickFacebookLink()
    {
        Hooks.driver.findElement(By.cssSelector("li.facebook > a")).click();
    }

    public void clickTwitterLink()
    {
        Hooks.driver.findElement(By.cssSelector("li.twitter> a")).click();
    }

    public void clickRssLink()
    {
        Hooks.driver.findElement(By.cssSelector("li.rss> a")).click();
    }

    public void clickYoutubeLink()
    {
        Hooks.driver.findElement(By.cssSelector("li.youtube> a")).click();
    }

    public void goNextTab() throws InterruptedException {

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Thread.sleep(5000);
        Hooks.driver.switchTo().window(tabs.get(1));
    }


    public void addHtcToWishList()
    {
        Hooks.driver.findElement(By.cssSelector("div.item-box:nth-child(3) button.add-to-wishlist-button")).click();
    }

    public String getBarnotificationBackGroundColor()
    {
        return Color.fromString((Hooks.driver.findElement(By.cssSelector("#bar-notification > div")).
                getCssValue("background-color"))).asHex();
    }

    public String getBarnotificationText()
    {
        return Hooks.driver.findElement(By.cssSelector("#bar-notification > div > p")).getText();
    }

    public void waitForNoficiationBarToDisappear()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
    }

    public int getWishListCounter() throws InterruptedException {

        Thread.sleep(5000);
        String stringText = Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")).getText();

        var removedBracesText =stringText.replaceAll("[\\[\\](){}]","");

        return Integer.parseInt(removedBracesText);


    }







}
