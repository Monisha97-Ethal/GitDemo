package WebDriverAssignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {
	WebDriver driver;

	@BeforeTest
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
	}
	@Test
	public void alertBox() throws InterruptedException  {

		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
	}
	
	@Test
	public void confirmAlert() throws InterruptedException  {
		driver.findElement(By.id("confirmbtn")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(5000);
		alert.dismiss();
		
	}
	@AfterTest
	public void closeWindow() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.close();
	}
	
	}


