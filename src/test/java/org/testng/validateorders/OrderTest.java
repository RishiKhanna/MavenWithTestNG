package org.testng.validateorders;

import java.util.Properties;

import org.ireg.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.pages.SignInPage;
import org.testng.propertymgr.PropertyManager;

public class OrderTest extends TestBase {

	private SignInPage signInPage;
	private final static Properties signinProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/signin.properties");

	@BeforeClass
	public void beforeClass(ITestContext context) throws InterruptedException {
		signInPage = new SignInPage((WebDriver)context.getAttribute(context.getCurrentXmlTest().getName()));
	}

	@Test
	public void applicationLoginIn() throws InterruptedException {
		Thread.sleep(20000);
		signInPage.enterUserName(signinProperties.getProperty("userName"));
	}

	@Test
	public void applicationLoginIn1() throws InterruptedException {
		Thread.sleep(10000);
		signInPage.enterUserName(signinProperties.getProperty("userName"));
	}

	@Test
	public void applicationLoginIn2() throws InterruptedException {
		signInPage.enterUserName(signinProperties.getProperty("userName"));
		//Thread.sleep(45000);
		//signInPage.enterPassword(signinProperties.getProperty("password"));
		//signInPage.clickLogin();
	}
}
