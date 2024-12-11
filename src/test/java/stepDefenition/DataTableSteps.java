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

public class DataTableSteps {
	WebDriver driver;
	@Given("User is in Login page")
	public void user_is_in_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.guvi.in/sign-in/");
		driver.manage().window().maximize();
	}

	@When("User Enters invalid credentials")
	public void user_enters_invalid_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		List<Map<String, String>> map = dataTable.asMaps();
		for (Map<String, String> reference : map) {
			String username1 = reference.get("username");
			String password1 = reference.get("password");
			
			WebElement userelement =   driver.findElement(By.id("email"));
			userelement.sendKeys(username1);
			WebElement passelement =  driver.findElement(By.id("password"));
			passelement.sendKeys(password1);
			driver.findElement(By.className("login-btn")).click();
			userelement.clear();
			passelement.clear();
		}
		driver.findElement(By.className("login-btn")).click();
		
	}

	@Then("ErrorMessage On the Screen")
	public void error_message_on_the_screen() {
	    
	}


}
