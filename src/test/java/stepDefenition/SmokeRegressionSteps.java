package stepDefenition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SmokeRegressionSteps {
	WebDriver driver;

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.guvi.in/sign-in/");
		driver.manage().window().maximize();
	    
	}

	@When("User enters Invalid {string} and {string}")
	public void user_enters_invalid_and(String username, String password) {
		WebElement userelement =   driver.findElement(By.id("email"));
		userelement.sendKeys(username);
		WebElement passelement =  driver.findElement(By.id("password"));
		passelement.sendKeys(password);
	}

	@Then("User is redirected to SigninPage with ErrorMessage")
	public void user_is_redirected_to_signin_page_with_error_message() {
		WebElement text=driver.findElement(By.xpath("//*[@id='emailgroup']/div/text()"));
		String actualResult=text.getText();
		String expectedResult=" Oh! No profile exists with this Email ID.";
		assertEquals(actualResult, expectedResult);
	    
	}




}
