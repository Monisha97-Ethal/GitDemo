package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	WebDriver driver;
	String searchContent="selenium practice websites";
	@BeforeTest
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
        
	}
	@Test
	public void search() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys(searchContent);
		searchBox.submit();		
		Thread.sleep(2000);	
	}
	
	@Test
	public void validateSearchResult() {
		String actualSearchResult=driver.getTitle();
		String expectedResult=searchContent+" - Google Search";
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
