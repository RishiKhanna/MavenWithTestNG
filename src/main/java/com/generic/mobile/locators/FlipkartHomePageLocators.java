package com.generic.mobile.locators;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public final class FlipkartHomePageLocators {

    public static final By BYSEARCHTEXT = MobileBy
            .AndroidUIAutomator("text(\"Search for products and brands\")");
    public static final By BYCARTBUTTON = By.id("com.flipkart.android:id/menu_cart");
    public static final By BYCARTNUM = MobileBy.AndroidUIAutomator("description(\"My Cart (1)\")");
}
