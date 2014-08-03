package org.testng.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

public class HomePageLocators {

	private final static Properties homeProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/home.properties");

	public static By lastName = By.id(homeProperties.getProperty("lastName"));
	public static By firstName = By.id(homeProperties.getProperty("firstName"));
	public static By address1 = By.id(homeProperties.getProperty("address1"));
	public static By address2 = By.id(homeProperties.getProperty("address2"));
	public static By city = By.id(homeProperties.getProperty("city"));
	public static By state = By.id(homeProperties.getProperty("state"));
	public static By zip = By.id(homeProperties.getProperty("zip"));
	public static By underGradProgOfInterest = By.id(homeProperties
			.getProperty("underGradProgOfInterest"));
	public static By underGradCertOfInterest = By.id(homeProperties
			.getProperty("underGradCertOfInterest"));
	public static By gradProgOfInterest = By.id(homeProperties
			.getProperty("gradProgOfInterest"));
	public static By gradCertOfInterest = By.id(homeProperties
			.getProperty("gradCertOfInterest"));
	public static By phAreadCode = By.id(homeProperties
			.getProperty("phAreadCode"));
	public static By phFirstThree = By.id(homeProperties
			.getProperty("phFirstThree"));
	public static By phLastFour = By.id(homeProperties
			.getProperty("phLastFour"));
	public static By email = By.id(homeProperties.getProperty("email"));
	public static By verifyEmail = By.id(homeProperties
			.getProperty("verifyEmail"));
	public static By submit = By.name(homeProperties.getProperty("submit"));
}
