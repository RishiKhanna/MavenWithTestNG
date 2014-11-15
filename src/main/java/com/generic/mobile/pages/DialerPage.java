package com.generic.mobile.pages;

import static com.generic.mobile.locators.DialerPageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.exceptions.WaitException;
import com.generic.page.base.MobilePageBase;

public class DialerPage extends MobilePageBase {

    public DialerPage(WebDriver driver) throws WaitException {
        super(driver);
        Assert.assertTrue(mobileActions.getVisibiltyOfElementLocatedBy(BYNUM0));
    }

    public DialerPage enterPhoneNumber(String number) throws TimeoutException, WaitException {
        String[] arr = number.split("");
        for (int i = 1; i < arr.length; i++) {
            String locator = "com.jbapps.contactpro:id/dial_btn_num" + arr[i];
            mobileActions.tap(VISIBILITY, By.id(locator));
        }
        return this;
    }

    public void addNewContact() throws TimeoutException, WaitException {
        mobileActions.tap(VISIBILITY, BYNEWCONTACT);
    }

    public void enterFamilyName(String value) throws TimeoutException, WaitException {
        mobileActions.enterText(VISIBILITY, BYFAMILYNAME, value);
    }

    public void enterGivenName(String value) throws TimeoutException, WaitException {
        mobileActions.enterText(VISIBILITY, BYGIVENNAME, value);
    }

    public void saveContact() throws TimeoutException, WaitException {
        mobileActions.tap(VISIBILITY, BYDONEBTN);
    }

    public void tapDialPad() throws TimeoutException, WaitException {
        mobileActions.tap(VISIBILITY, BYDIALPAD);
    }

    public void swipeToContacts(int xstart, int ystart, int xend, int yend, int duration) {
        mobileActions.swipeOnScreen(xstart, ystart, xend, yend, duration);
    }

    public void changeOrientation(String orientation) {
        mobileActions.setOrientationTo(orientation);
    }

    public void closeApp() {
        mobileActions.closeApp();
    }

}
