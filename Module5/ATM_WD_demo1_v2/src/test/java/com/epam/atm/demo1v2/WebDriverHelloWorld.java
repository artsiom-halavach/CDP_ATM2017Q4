package com.epam.atm.demo1v2;

		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelloWorld {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // Maximize browser window via options, just an example
		WebDriver driver = new ChromeDriver(options);

		// Open web page for moving through demo steps
		driver.get("https://mvnrepository.com/");

		// setting standard timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		// Maximize browser window
//		driver.manage().window().maximize();
		WebElement mvnSearchInput = driver.findElement(By.cssSelector("input#query.textfield"));
		mvnSearchInput = driver.findElement(By.id("query"));
		mvnSearchInput.sendKeys("selenium java");
		WebElement mvnSearchBtn = driver.findElement(By.xpath("//input[@value='Search']"));
		mvnSearchBtn.click();
		Thread.sleep(3000);
		WebElement mvnSearchResult = driver.findElement(By.xpath("//div[@class='im-header']//h2[@class='im-title']/a[text()='Selenium Java']"));

		driver.quit();
		System.out.println("Browse was successfully quited.");
	}
}
