package com.epam.atm.demo1v2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverMVNSearchTest {
	private static final String MVNREPOSITORY_URL = "https://mvnrepository.com/";
	private static final String SEARCH_INPUT_ID = "query";
	private static final String WD_VERSION = "3.8.1";
	private static final String WEBDRIVER_LIB_RELEASE_LINK = String
			.format("//table[@class='grid versions']//a[@class='vbtn release'][text()='%s']", WD_VERSION);
	private static final String SEARCH_RESULT_ITEM = "//div[@class='im-header']//h2[@class='im-title']/a[text()='Selenium Java']";
	private static final String SEARCH_BTN = "//input[@value='Search']";
	private static final String SEARCH_STRING = "selenium java";
	private static final String QUERY_TEXTFIELD = "input#query.textfield";
	private WebDriver driver;
	private WebElement mvnSearchInput;
	private WebElement mvnSearchBtn;
	private WebElement mvnSearchResult;
	private WebElement wdReleaseLink;

	@BeforeClass(description = "Start browser")
	public void startBrowser() {
		//alternative way to set environmental variable at runtime
		System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		// Maximize browser window via options, just an example
		options.addArguments("start-maximized"); 
		
		driver = new ChromeDriver(options);

		// Open web page for moving through demo steps
		driver.get(MVNREPOSITORY_URL);

		// setting standard timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize(); //alternative way to change window size at runtime
	}

	@Test(description = "looking for WebDriver dependency within maven repository")
	public void searchForWebDriverDependency() throws InterruptedException {
		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(QUERY_TEXTFIELD)));
		// mvnSearchInput = driver.findElement(By.cssSelector(QUERY_TEXTFIELD));
		mvnSearchInput = driver.findElement(By.id(SEARCH_INPUT_ID));
		highlightElement(mvnSearchInput);
		mvnSearchInput.clear();
		mvnSearchInput.sendKeys(SEARCH_STRING);
		mvnSearchBtn = driver.findElement(By.xpath(SEARCH_BTN));
		highlightElement(mvnSearchBtn); // just to add some visual effect
		mvnSearchBtn.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULT_ITEM)));
		mvnSearchResult = driver.findElement(By.xpath(SEARCH_RESULT_ITEM));
		highlightElement(mvnSearchResult);// just to add some visual effect
		Assert.assertTrue(mvnSearchResult.isDisplayed(), "No required search result element on the page!");
		System.out.println("WebDriver java binding is available in maven central repository.");
	}

	@Test(description = "looking for WebDriver dependency SPECIFIC VERSION ", dependsOnMethods = {
			"searchForWebDriverDependency" })
	public void searchForWebDriverDependencyVersion() throws InterruptedException {
		mvnSearchResult.click();
		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WEBDRIVER_LIB_RELEASE_LINK)));
		wdReleaseLink = driver.findElement(By.xpath(WEBDRIVER_LIB_RELEASE_LINK));
		highlightElement(wdReleaseLink);
		Assert.assertTrue(wdReleaseLink.isDisplayed(), "No dependency for required version is found on the page!");
		System.out.println(WD_VERSION + " is available in maven central repository.");
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
		System.out.println("Browser was successfully quited.");
	}

	public void highlightElement(WebElement element) throws InterruptedException {
		String bg = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
		// take screenshot here
		// or just pause/blink
		Thread.sleep(500);
		js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);

	}
}
