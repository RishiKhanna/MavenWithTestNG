package com.generic.mobile.locators;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

public final class DialerPageLocators {

    public static final By BYNUM1 = By.id("com.jbapps.contactpro:id/dial_btn_num1");
    public static final By BYNUM2 = By.id("com.jbapps.contactpro:id/dial_btn_num2");
    public static final By BYNUM3 = By.id("com.jbapps.contactpro:id/dial_btn_num3");
    public static final By BYNUM4 = By.id("com.jbapps.contactpro:id/dial_btn_num4");
    public static final By BYNUM5 = By.id("com.jbapps.contactpro:id/dial_btn_num5");
    public static final By BYNUM6 = By.id("com.jbapps.contactpro:id/dial_btn_num6");
    public static final By BYNUM7 = By.id("com.jbapps.contactpro:id/dial_btn_num7");
    public static final By BYNUM8 = By.id("com.jbapps.contactpro:id/dial_btn_num8");
    public static final By BYNUM9 = By.id("com.jbapps.contactpro:id/dial_btn_num9");
    public static final By BYNUM0 = By.id("com.jbapps.contactpro:id/dial_btn_num0");
    public static final By BYNEWCONTACT = By.id("com.jbapps.contactpro:id/dial_newnumber_listitem");
    public static final By BYFAMILYNAME = MobileBy.AndroidUIAutomator("text(\"Family name\")");
    public static final By BYGIVENNAME = MobileBy.AndroidUIAutomator("text(\"Given name\")");
    public static final By BYDONEBTN = MobileBy.AndroidUIAutomator("text(\"Done\")");
    public static final By BYDIALPAD = By.id("com.jbapps.contactpro:id/bottom_dial");
}
