package com.webdriver.basic;

import com.sun.xml.internal.stream.buffer.stax.StreamWriterBufferCreator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.JavascriptExecutor.*;

/**
 * Created by Artsiom_Halavach1 on 12/20/2017.
 */
public class WebDriverTest {
    private static final String MAINPAGE = "https://uk.practicallaw.thomsonreuters.com/";
    private static final String ASK_FORM = "//*[@id=\'co_pageHeader\']/div[2]/div/a";
    private WebDriver driver;
    private WebElement askFormBtn;
    private WebElement textInput;
//    private WebDriver driver = new FirefoxDriver();
//
//    public CommonMethods() {
//        super(driver);
//    }
public static boolean isElementPresent(WebDriver driver, By by) {
    try {
        driver.findElement(by);
        return true;  // Success!
    } catch (NoSuchElementException ignored) {
        return false;
    }
}

    @BeforeTest(description = "Start browser")
    public void startBrowser() {
        //alternative way to set environmental variable at runtime
        System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

//        FirefoxOptions options = new FirefoxOptions();


        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
//        driver = new FirefoxDriver(options);
        driver.manage().window().fullscreen();
        driver.get(MAINPAGE);

        // setting standard timeout
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#CookieConsentMessageClose")).click();

    }

    public void waitForElement(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    //  AskForm
    @Test
    public void AskFormexecutaion() throws Exception {

        askFormBtn = driver.findElement(By.xpath(ASK_FORM));
        askFormBtn.click();
        String winHandleBefore = driver.getWindowHandle();

//        Switch to ASK window form
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String winHandleAsk = driver.getWindowHandle();
//        Set up details
        driver.findElement(By.cssSelector("#IsCheckedTerms")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Artsiom");
        driver.findElement(By.id("LastName")).sendKeys("Halavach");
        driver.findElement(By.id("Email")).sendKeys("test@google.com");

        Select orgType = new Select(driver.findElement(By.cssSelector("#OrganisationType")));
        orgType.selectByVisibleText("Public Sector");

        Select position = new Select(driver.findElement(By.cssSelector("#Position")));
        position.selectByVisibleText("Legal Advisor");

        Select jurisdiction = new Select(driver.findElement(By.cssSelector("#Jurisdiction")));
        jurisdiction.selectByVisibleText("UK");

        Select answeringService = new Select(driver.findElement(By.cssSelector("#AnsweringService")));
        answeringService.selectByVisibleText("Tax");

        driver.findElement(By.cssSelector("#cancelAskFormButton")).click();

        Assert.assertFalse(driver.getWindowHandles().contains("winHandleAsk"), "still appearing");
        driver.switchTo().window(winHandleBefore);
    }

    public static ExpectedCondition<WebElement> elementToBeClickable(By locator) {
        return null;
    }

    ;


    //  Twitter
    @Test
    public void twitterTest() throws InterruptedException {


        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        WebElement element = driver.findElement();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("footer-twitter")));
        System.out.println("moving bot");

        WebElement twitter = driver.findElement(By.id("footer-twitter"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        twitter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer-twitter")));

        System.out.println("click on twitter");
        driver.findElement(By.cssSelector("#footer-twitter")).click();
        driver.findElement(By.cssSelector("#twitter-links > div.co_dropDownMenuContent > ul > li:nth-child(1) > a")).click();
        System.out.println("scrolling twitter");
        WebElement element = driver.findElement(By.xpath("//*[@id=\'stream-item-tweet-940514074344833024\']//div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);


//            Opening post and verify text
        driver.findElement(By.xpath("//*[@id=\'stream-item-tweet-940514074344833024\']//iframe")).click();
        Assert.assertTrue(driver.getPageSource().contains("Merry Christmas to mediators!"));

//              Switch to twitter and pack to PL
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.navigate().back();


    }

//Feedback
    @Test
    public void Feedback() throws Exception {
        WebElement feedback = driver.findElement(By.cssSelector("#PracticalLawFeedbackLink"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        feedback = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#PracticalLawFeedbackLink")));


        driver.findElement(By.cssSelector("#PracticalLawFeedbackLink")).click();
        driver.findElement(By.cssSelector("#co_search_lightbox_closeButton")).click();
        Assert.assertFalse( isElementPresent(driver, By.xpath("//*[@id='co_feedback']")));
    }




    @AfterTest(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
        System.out.println("Browser was successfully quited.");
    }


}

