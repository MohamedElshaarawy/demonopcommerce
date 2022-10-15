package org.example.stepDefs;


 import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Hooks {
    public static WebDriver driver;

    @Before
    public static void OpenBrowser() {
        // 1- Bridge
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");// "C:\\Program Files\\chromedriver.exe");
        //Note: you could use WebDriverManager.chromedriver().setup() instead of System.setProperty() as explained in the videos

        // 2- create object from chrome browser
        driver = new ChromeDriver();

        // 3- Configurations driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // 4- navigate to url
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");





    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000); driver.quit();
    }
}