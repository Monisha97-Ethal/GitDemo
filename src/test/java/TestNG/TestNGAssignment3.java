package TestNG;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAssignment3 {
	WebDriver driver;

	@BeforeMethod
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
        
	}
	@Test(dataProvider = "getData")

	public void login(HashMap<String, String> input) throws IOException, InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("userEmail")).sendKeys(input.get("email"));
		driver.findElement(By.id("userPassword")).sendKeys(input.get("Password"));
		driver.findElement(By.id("login")).click();
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data=getJsonDatatoMap(System.getProperty("user.dir")+
				"\\src\\test\\resources\\credentials.json");
		return new Object[][]  {{data.get(0)},{data.get(1)}};
		
		
	}
	public List<HashMap<String,String>> getJsonDatatoMap(String filePath) throws IOException{
		String jsonContent=FileUtils.readFileToString(new File(filePath));	
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=
				mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;

	}
	@AfterTest
	public void closeWindow() throws InterruptedException {
		Thread.sleep(2000);	
	    driver.close();
	}
	
	

}
