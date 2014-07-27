package org.testng.validateorders;

import java.util.Properties;

import org.ireg.testbase.TestBase;
import org.testng.annotations.Test;
import org.testng.propertymgr.PropertyManager;

public class OrderTest extends TestBase {

	private final static Properties signinProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/signin.properties");
	
	@Test
	public void applicationLoginIn() {
		signInPage.enterUserName(signinProperties.getProperty("userName"));
		signInPage.enterPassword(signinProperties.getProperty("password"));
		signInPage.clickLogin();
	}
}
