package com.generic.mobile.locators;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public final class FlipkartLoginPageLocators {

    public static final By BYUSERNAME = MobileBy
            .AndroidUIAutomator("description(\"email_textbox\")");
    public static final By BYPASSWORD = MobileBy
            .AndroidUIAutomator("description(\"password_textbox\")");
    public static final By BYLOGIN = MobileBy.AndroidUIAutomator("description(\"login_button\")");
    public static final By BYMULTIWIDGETROOT = By.id("com.flipkart.android:id/multiwidgetroot");
}
