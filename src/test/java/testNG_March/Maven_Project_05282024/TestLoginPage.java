package testNG_March.Maven_Project_05282024;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginPage {

	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();

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

		WebElement termsAndConditionLink = driver.findElement(By.xpath("//a[@href=\"/static/terms.html\"]"));

		WebElement checkboxTerms = driver.findElement(By.cssSelector("input[name='agreeTerms']"));

		WebElement submitButton = driver.findElement(By.cssSelector("div.myButton"));

		// Perform Actions
		Select dropdown = new Select(editionInput);

		dropdown.selectByVisibleText("Free Edition");

		firstNameInput.sendKeys("Arshdeep");

		lastNameInput.sendKeys("Kaur");

		emailInput.sendKeys("arshaujla93@gmail.com");

		confirmEmailInput.sendKeys("arshaujla93@gmail.com");

		usernameInput.sendKeys("Arsh123");

		passwordInput.sendKeys("Arsh2214.");

		confirmPasswordInput.sendKeys("Arsh2214.");

		termsAndConditionLink.click();

		checkboxTerms.click();

		submitButton.click();

	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}

}
