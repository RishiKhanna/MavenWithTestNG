package com.generic.web.pages.locators;

import org.openqa.selenium.By;

public interface HomePageLocators {

	By lastName = By.id("last");
	By firstName = By.id("first");
	By address1 = By.id("address1");
	By address2 = By.id("address2");
	By city = By.id("city");
	By state = By.id("state");
	By zip = By.id("zip");
	By underGradProgOfInterest = By.id("undergraduate program");
	By underGradCertOfInterest = By
			.id("undergraduate certificate");
	By gradProgOfInterest = By.id("graduate program");
	By gradCertOfInterest = By.id("graduate certificate");
	By phAreadCode = By.id("phone-area code");
	By phFirstThree = By.id("phone-first three digits");
	By phLastFour = By.id("phone-last four digits");
	By email = By.id("e-mail");
	By verifyEmail = By.id("verify e-mail");
	By submit = By.name("Submit");
}
