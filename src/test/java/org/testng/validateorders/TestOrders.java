package org.testng.validateorders;

import java.util.Properties;

import org.ireg.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.pages.SignInPage;
import org.testng.propertymgr.PropertyManager;

public class TestOrders extends TestBase {

	private SignInPage signInPage;
	private final static Properties signinProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/signin.properties");

	@BeforeClass
	public void beforeClass(ITestContext context) throws InterruptedException {
		signInPage = new SignInPage((WebDriver)context.getAttribute(context.getCurrentXmlTest().getName()));
	}

	@Test
	public void applicationPasswordIn() throws InterruptedException {
		signInPage.enterPassword(signinProperties.getProperty("password"));
		signInPage.clickLogin();
	}

	@Test
	public void applicationPasswordIn1() throws InterruptedException {
		signInPage.enterPassword(signinProperties.getProperty("password"));
		signInPage.clickLogin();
	}

	@Test
	public void applicationPasswordIn2() throws InterruptedException {
		signInPage.enterPassword(signinProperties.getProperty("password"));
		signInPage.clickLogin();
	}
}
