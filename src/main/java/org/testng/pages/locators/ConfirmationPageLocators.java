package org.testng.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class ConfirmationPageLocators {

	private final static Properties homeProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/confirmation.properties");

	public static By confirmMessage = By.cssSelector(homeProperties.getProperty("confirmMessage"));
}
