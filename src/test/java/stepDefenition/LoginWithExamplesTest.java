package stepDefenition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithExamplesTest {
	WebDriver driver;
	@Given("User is on the LoginPage")
	public void user_is_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.guvi.in/sign-in/");
		driver.manage().window().maximize();
	    
	}

	@When("User Enter invalid {string} and {string}")
	public void user_enter_invalid_and(String username, String password) {
		WebElement username1 = driver.findElement(By.id("email"));
		WebElement password1 = driver.findElement(By.id("password"));
		username1.clear();
		password1.clear();
		username1.sendKeys(username);
		password1.sendKeys(password);
		driver.findElement(By.className("login-btn")).click();
		
	   
	}

	@Then("Error Message is being displayed")
	public void error_message_is_being_displayed() {
	   
	}




}
