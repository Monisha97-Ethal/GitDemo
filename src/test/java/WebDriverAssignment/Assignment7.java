package WebDriverAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {
	
	WebDriver driver;
	Actions action;
	@BeforeMethod
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		driver.get("https://formy-project.herokuapp.com/dragdrop");
		WebElement from=driver.findElement(By.id("image"));
		WebElement to=driver.findElement(By.id("box"));
		 action=new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
		Thread.sleep(3000);

	}
	@Test
	public void mouseHover() throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 action=new Actions(driver);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement mouseHover=driver.findElement(By.className("mouse-hover"));
		//js.executeScript("argument[0].scrollIntoView[true]", mouseHover);
		action.moveToElement(mouseHover).build().perform();
		String selectContent="Reload";
		String stringToSelect="//a[text()='"+selectContent+"']";
		System.out.println(stringToSelect);
		WebElement select=driver.findElement(By.xpath(stringToSelect));
		select.click();
		Thread.sleep(3000);	

	}
	 
	@AfterMethod
	
	public void closeWindow() throws InterruptedException {
	    driver.close();
	}

}
