package testNG_March.Maven_Project_05282024;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginPage {

	WebDriver driver;

	String browser = "chrome";

	GenerateRandomData randomdata = new GenerateRandomData();

	@BeforeMethod
	public void openBrowser() {

		browserSetup();
		driver.get("https://classic.freecrm.com/register/");
	}

	@Test
	public void testLoginPage() {

		WebElement editionInput = driver.findElement(By.id("payment_plan_id"));

		WebElement firstNameInput = driver.findElement(By.cssSelector("input[name='first_name']"));

		WebElement lastNameInput = driver.findElement(By.cssSelector("input[name='surname']"));

		WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

		WebElement confirmEmailInput = driver.findElement(By.xpath("//input[@name='email_confirm']"));

		WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));

		WebElement passwordInput = driver
				.findElement(By.cssSelector("div.text_normal form div.form-group.has-feedback:nth-of-type(8) input"));

		WebElement confirmPasswordInput = driver
				.findElement(By.cssSelector("div.text_normal form div.form-group.has-feedback:nth-of-type(9) input"));

		WebElement termsAndConditionLink = driver.findElement(By.cssSelector("a[href='/static/terms.html']"));

		WebElement checkboxTerms = driver.findElement(By.cssSelector("input[name='agreeTerms']"));

		WebElement submitButton = driver.findElement(By.cssSelector("div.myButton"));

		Select dropdown = new Select(editionInput);

		String randomPassword = randomdata.getPassword();

		String randomEmail = randomdata.getEmail();

		dropdown.selectByVisibleText("Free Edition");

		firstNameInput.sendKeys(randomdata.getFirstName());

		lastNameInput.sendKeys(randomdata.getLastName());

		emailInput.sendKeys(randomEmail);

		confirmEmailInput.sendKeys(randomEmail);

		usernameInput.sendKeys(randomdata.getUsername());

		passwordInput.sendKeys(randomPassword);

		confirmPasswordInput.sendKeys(randomPassword);

		termsAndConditionLink.click();

		checkboxTerms.click();

		submitButton.click();

	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}

	private void browserSetup() {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edgedriver":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new InvalidArgumentException("browser value is invalid " + browser);

		}
	}

}
