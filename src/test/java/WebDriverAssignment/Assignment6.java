package WebDriverAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {
	WebDriver driver;

	@BeforeTest
	public void chromeSetUp() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.guvi.com");
        
	}
	@Test
	public void login() throws InterruptedException {
		   driver.findElement(By.linkText("Login")).click();
		   Thread.sleep(5000);
		   driver.findElement(By.id("email")).sendKeys("");
		   driver.findElement(By.id("password")).sendKeys("");
		   driver.findElement(By.linkText("Login")).click();
	}
	@AfterTest
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);	
	    driver.close();
	}
}
