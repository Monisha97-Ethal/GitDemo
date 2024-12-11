package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	
	WebDriver driver;
	String searchContent="selenium practice websites";

	@BeforeMethod
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@Test
	public void navigation() throws InterruptedException {
		driver.navigate().to("https://www.Google.com");
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys(searchContent);
		searchBox.submit();
		String actualSearchResult,expectedResult;
		Thread.sleep(3000);
		 actualSearchResult=driver.getTitle();
		 expectedResult=searchContent+" - Google Search";
		 validation(actualSearchResult, expectedResult);
		 driver.navigate().back();
			Thread.sleep(3000);
		 actualSearchResult=driver.getTitle();
		 expectedResult="Google";
		 validation(actualSearchResult, expectedResult);
		 driver.navigate().forward();
			Thread.sleep(3000);
		 actualSearchResult=driver.getTitle();
		 expectedResult=searchContent+" - Google Search";
		 validation(actualSearchResult, expectedResult);
		 driver.navigate().refresh();
			Thread.sleep(3000);
		 actualSearchResult=driver.getTitle();
		 expectedResult=searchContent+" - Google Search";
		 validation(actualSearchResult, expectedResult);
	}
	
	public void validation(String actualSearchResult,String expectedResult) {
		
		System.out.println(actualSearchResult);
		System.out.println(expectedResult);
		Assert.assertEquals(actualSearchResult, expectedResult);
	}
	@AfterTest
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);	
	    driver.close();
	}
}
