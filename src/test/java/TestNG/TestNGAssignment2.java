package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAssignment2 {
	WebDriver driver;
	
	@Test
	
	public void launchChrome() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.capgemini.com/");
        Thread.sleep(5000);	
        System.out.println(driver.getTitle()+" in Chrome");
	    driver.close();
	}
	@Test
	public void launchFireFox() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
        Thread.sleep(5000);	
        System.out.println(driver.getTitle()+" in FireFox");
	    driver.close();
	}
}
