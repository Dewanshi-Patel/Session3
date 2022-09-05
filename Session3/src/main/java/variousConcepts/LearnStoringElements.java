package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnStoringElements {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {
//		Storing element using WebElement (Creating a variable so it can be re used. )
//		type name = value
//		int a = 5;
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@class='btn btn-success block full-width']"));
		
		
		

//		Storing element using By class
		By USERNAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//input[@type='password']");
		By SIGNIN_BUTTON_FIELD = By.xpath("//button[@class='btn btn-success block full-width']");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		
//		h2[@style='color: #2F4050; font-size: 16px; font-weight: 400; margin-top: 18px']

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");

//	 	Perform Login

		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.findElement(SIGNIN_BUTTON_FIELD).click();
		

//		Assertion(Validating that a page exists)
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));

		WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		

		
		
		
		Assert.assertTrue("Wrong Page!!!", DASHBOARD_HEADER_ELEMENT.isDisplayed());
//		Assert.assertTrue("Wrong Page!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
		
		
		
		
		
		
		
		
		
		
		
		

//		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
//		USERNAME_FIELD.findElement(USERNAME_ELEMENT).sendKeys("demo@techfios.com");
//
//		PASSWORD_ELEMENT.sendKeys("abc123");
//		PASSWORD_FIELD.findElement(PASSWORD_ELEMENT).sendKeys("abc123");
//
//		SIGNIN_BUTTON_ELEMENT.findElement(SIGNIN_BUTTON_FIELD).click();
//		SIGNIN_BUTTON_FIELD.findElement(SIGNIN_BUTTON_ELEMENT).click();
//
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123");
//		driver.findElement(By.xpath("//button[@class='btn btn-success block full-width']")).click();

	}

}
