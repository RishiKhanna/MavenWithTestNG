package com.generic.mobile.pages;

import static com.generic.mobile.locators.FlipkartHomePageLocators.*;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.actions.IMobileAction;
import com.generic.actions.SyncMobileWait;
import com.generic.exceptions.WaitException;
import com.generic.page.base.MobilePageBase;

public class FlipkartHomePage extends MobilePageBase {

    public FlipkartHomePage(WebDriver driver) throws WaitException {
        super(driver);
        Assert.assertTrue(mobileActions.getVisibiltyOfElementLocatedBy(BYCARTBUTTON));
    }

    public FlipkartHomePage getSearchBoxText() throws TimeoutException, WaitException {
        mobileActions.getText(VISIBILITY, BYSEARCHTEXT);
        return this;
    }

    public FlipkartHomePage tapAddToCart() throws TimeoutException, WaitException,
            InterruptedException {
        IMobileAction action = new SyncMobileWait(mobileActions);
        action.tap(VISIBILITY, BYCARTBUTTON);
        return this;
    }

    public boolean getNumberOfItems() throws TimeoutException, WaitException {
        return mobileActions.getVisibiltyOfElementLocatedBy(BYCARTNUM);
    }
}
