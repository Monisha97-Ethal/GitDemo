package WebDriverAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Assignment3 {
	
	WebDriver driver;
	@BeforeTest
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_iframe.asp");
        
	}
	@Test
	public void iframeSwitch() throws InterruptedException {
		Thread.sleep(5000);
		WebElement frame=driver.findElement(By.xpath("//iframe[@title='W3Schools HTML Tutorial']"));
		
		driver.switchTo().frame(frame);
		Thread.sleep(5000);
		driver.findElement(By.linkText("CSS")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("HTML Id")).click();
		
		
			}
	@AfterTest
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);	
	    driver.close();
	}
}
