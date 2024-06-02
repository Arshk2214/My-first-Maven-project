package testNG_March.Maven_Project_05282024;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNgExample {

	@BeforeClass
	public void inaugration() {
		System.out.println("Running tests ");
	}

	@BeforeMethod
	public void openBrowser() {

		System.out.println("Open browser");
	}

	// @Ignore
	@Test(enabled = false) // annotation
	public void verifyValidLoginCredentials() {

		System.out.println("Testing valid credentials");

	}

	@Test(priority = 1, invocationCount = 3) // attributes
	public void verifyInvalidLoginCredentialsMultipleTimes() {

		System.out.println("Testing invalid credentials");

	}

	@Test(priority = 3)
	public void validateHelpButtonFunctionality() {

		System.out.println("Testing help button");

	}

	@AfterMethod
	public void closeBrowser() {

		System.out.println("Close browser");

	}

	@AfterClass
	public void complete() {

		System.out.println("Testing  is done");

	}

}
