package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAssignment4 {
WebDriver driver;
	
	@Test(groups = {"launch"})
	
	public void launchChrome() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.capgemini.com/");
        Thread.sleep(5000);	
        System.out.println(driver.getTitle()+" in Chrome");
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, "Capgemini - Get The Future You Want");
	    driver.close();
	}
	@Test(groups = {"launch"})
	public void launchFireFox() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
        Thread.sleep(5000);	
        System.out.println(driver.getTitle()+" in FireFox");
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, "Google");
	    driver.close();
	}
	
	@Test(enabled = true)
	public void launchEdge() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
        Thread.sleep(5000);	
        System.out.println(driver.getTitle()+" in FireFox");
	    driver.close();
	}
	

}
