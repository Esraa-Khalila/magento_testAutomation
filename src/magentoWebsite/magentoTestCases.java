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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	public void Register() {
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
		assertEquals(welcomeMsg, "Thank you for registering with Main Website Store.");

	}

	@Test(priority = 2)
	public void logout() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess/"), true);
	}

	@Test(priority = 3)
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		email.sendKeys(emailID);
		password.sendKeys(CommonPassword);

		WebElement loginButton = driver.findElement(By.id("send2"));
		loginButton.click();
		Thread.sleep(3000);
		String welcomeMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(welcomeMsg.contains("Welcome"), true);

	}

	@Test(priority = 4)
	public void addRandomItem() {
		driver.get(baseUrl);

		WebElement containerItem = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
//		int numberOfItem= containerItem.findElements(By.tagName("li")).size();
		int randomItem = Rand.nextInt(4);
		containerItem.findElements(By.tagName("li")).get(randomItem).click();

//		random click on size
		WebElement containerSize = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int numberOfSize = containerSize.findElements(By.className("swatch-option")).size();
		int randomSize = Rand.nextInt(numberOfSize);
		containerSize.findElements(By.className("swatch-option")).get(randomSize).click();

//		random click on color
		WebElement containerColor = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int numberOfColor = containerColor.findElements(By.className("swatch-option")).size();
		int RandomColor = Rand.nextInt(numberOfColor);
		containerColor.findElements(By.className("swatch-option")).get(RandomColor).click();

		WebElement addButton = driver.findElement(By.id("product-addtocart-button"));
		addButton.click();

		String ActualMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(ActualMsg.contains("You added"), true);

	}
}
