package org.testng.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class SignInPageLocators {

	private final static Properties homeProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/home.properties");
	
	public static By userNameLocator = By.id(homeProperties.getProperty("userNameLocator"));
	public static By passwordLocator = By.id(homeProperties.getProperty("passwordLocator"));
	public static String signInButtonLocator = homeProperties.getProperty("signInButtonLocator");
	
	

}
