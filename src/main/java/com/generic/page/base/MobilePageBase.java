package com.generic.page.base;

import org.openqa.selenium.WebDriver;
import com.generic.actions.MobileActions;
import com.generic.exceptions.WaitException;

public class MobilePageBase extends PageBase {

    protected WebDriver driver;
    protected MobileActions mobileActions;

    public MobilePageBase(WebDriver driver) throws WaitException {
        this.driver = driver;
        this.mobileActions = new MobileActions(driver);
    }
}
