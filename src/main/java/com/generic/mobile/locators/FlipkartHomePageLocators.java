package com.generic.mobile.locators;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public interface FlipkartHomePageLocators {

	By bySearchText = MobileBy.AndroidUIAutomator("text(\"Search for products and brands\")");
	By byCartButton = By.id("com.flipkart.android:id/menu_cart");
}
