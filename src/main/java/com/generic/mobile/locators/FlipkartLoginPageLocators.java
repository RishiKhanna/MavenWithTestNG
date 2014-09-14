package com.generic.mobile.locators;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public interface FlipkartLoginPageLocators {

	By byUsername = MobileBy
			.AndroidUIAutomator("description(\"email_textbox\")");
	By byPassword = MobileBy
			.AndroidUIAutomator("description(\"password_textbox\")");
	By byLogin = MobileBy.AndroidUIAutomator("description(\"login_button\")");
	By byMultiWidgetRoot = By.id("com.flipkart.android:id/multiwidgetroot");
}
