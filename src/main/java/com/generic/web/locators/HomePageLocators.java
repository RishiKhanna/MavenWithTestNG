package com.generic.web.locators;

import org.openqa.selenium.By;

public final class HomePageLocators {

    public static final By LASTNAME = By.id("last");
    public static final By FIRSTNAME = By.id("first");
    public static final By ADDRESS1 = By.id("address1");
    public static final By ADDRESS2 = By.id("address2");
    public static final By CITY = By.id("city");
    public static final By STATE = By.id("state");
    public static final By ZIP = By.id("zip");
    public static final By UNDERGRADPROGOFINTEREST = By.id("undergraduate program");
    public static final By UNDERGRADCERTOFINTEREST = By.id("undergraduate certificate");
    public static final By GRADPROGOFINTEREST = By.id("graduate program");
    public static final By GRADCERTOFINTEREST = By.id("graduate certificate");
    public static final By PHAREADCODE = By.id("phone-area code");
    public static final By PHFIRSTTHREE = By.id("phone-first three digits");
    public static final By PHLASTFOUR = By.id("phone-last four digits");
    public static final By EMAIL = By.id("e-mail");
    public static final By VERIFYEMAIL = By.id("verify e-mail");
    public static final By SUBMIT = By.name("Submit");

    // Flipkart locators
    public static final By BYLOGIN = By.linkText("Login");
    public static final By BYUSERNAME = By.id("login_email_id1");
    public static final By BYPASSWORD = By.id("login_password1");
    public static final By BYLOGINBUTTON = By.cssSelector("button#login-cta.btn.btn-blue");
    public static final By FIRSTDAILYOFFERITEM = By
            .cssSelector(".offers-wrap.ccarousel-item.no-js.fk-inline-block:nth-of-type(3)");
    public static final By BUYNOWBUTTON = By.xpath("//input[@type='submit' and @value='Buy Now']");
    public static final By CANCELDIALOGUEBUTTON = By
            .cssSelector("close-icon.close.header-close-icon");
}
