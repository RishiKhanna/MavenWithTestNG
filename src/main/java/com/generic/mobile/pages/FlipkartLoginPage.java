package com.generic.mobile.pages;

import static com.generic.mobile.locators.FlipkartLoginPageLocators.*;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.exceptions.WaitException;
import com.generic.page.base.MobilePageBase;

public class FlipkartLoginPage extends MobilePageBase {

    public FlipkartLoginPage(WebDriver driver) throws WaitException {
        super(driver);
        Assert.assertTrue(mobileActions.getVisibiltyOfElementLocatedBy(BYUSERNAME));
    }

    public FlipkartLoginPage enterUserName(String username) throws TimeoutException, WaitException {
        mobileActions.enterText(VISIBILITY, BYUSERNAME, username);
        return this;
    }

    public FlipkartLoginPage enterPassword(String password) throws TimeoutException, WaitException {
        mobileActions.enterText(VISIBILITY, BYPASSWORD, password);
        return this;
    }

    public FlipkartLoginPage clickLogin() throws TimeoutException, WaitException {
        mobileActions.click(VISIBILITY, BYLOGIN);
        return this;
    }

    public FlipkartHomePage tapMultiWidgetRoot() throws TimeoutException, WaitException {
        mobileActions.tap(VISIBILITY, BYMULTIWIDGETROOT);
        return new FlipkartHomePage(driver);
    }
}
