package stepDefenition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberBasicStep {
	WebDriver driver;
	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String email, String Password) throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.guvi.com");
	   driver.findElement(By.linkText("Login")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.id("email")).sendKeys(email);
	   driver.findElement(By.id("password")).sendKeys(Password);
	   driver.findElement(By.linkText("Login")).click();
		System.out.println(driver.getCurrentUrl());

	}

	@Then("User is redirected to Homepage")
	public void user_is_redirected_to_homepage() throws InterruptedException {
		   Thread.sleep(5000);
		   String actualCurrentURL=driver.getCurrentUrl();
		   String expectedCurrentURL="https://www.guvi.com/courses/?current_tab=myCourses";
		   assertEquals(expectedCurrentURL, actualCurrentURL);

		System.out.println(driver.getCurrentUrl());
	    
	}
}
