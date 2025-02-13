package magentoWebsite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class magentoTestCases extends Parameters {
	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://magento.softwaretestingboard.com/";

	@BeforeTest
	public void setupTest() {
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void Login() {
		driver.get(baseUrl);
		
		WebElement redirectLogin = driver.findElement(By.linkText("Create an Account"));
		redirectLogin.click();
		
		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));
		WebElement email = driver.findElement(By.id("email_address"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement commonPassword = driver.findElement(By.id("password-confirmation"));
		WebElement loginButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		
		firstName.sendKeys(firstNames[randomIndex]);
		lastName.sendKeys(lastNames[randomIndex]);
		email.sendKeys(emailID);
		password.sendKeys(CommonPassword);
		commonPassword.sendKeys(CommonPassword);
		loginButton.click();
		
		String welcomeMsg = driver.findElement(By.className("message-success")).getText();
		assertEquals( welcomeMsg,"Thank you for registering with Main Website Store.");
	
		
		
	}

}
