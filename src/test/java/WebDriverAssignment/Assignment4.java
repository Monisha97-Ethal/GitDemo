package WebDriverAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {
	WebDriver driver;

	@BeforeTest
	public void chromeSetUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
        
	}
	@Test
	public void explicitWaitExample() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("userEmail")).sendKeys("qeea@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ethalya008");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-2")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-2"));
		WebElement prod=products.stream().filter(p->p.findElement(By.xpath("//*[@id='products']/div[1]/div[2]/div[1]/div/div/h5/b")).
				getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='products']/div[1]/div[2]/div[1]/div/div/button[2]")));
		prod.findElement(By.xpath("//*[@id='products']/div[1]/div[2]/div[1]/div/div/button[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		Thread.sleep(5000);		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			}
	@AfterTest
	public void closeWindow() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.close();
	}
}
