package com.generic.page.base;

import org.openqa.selenium.WebDriver;

import com.generic.actions.WebActions;
import com.generic.exceptions.URLNavigationException;
import com.generic.exceptions.WaitException;
import com.generic.web.pages.HomePage;

public class WebPageBase extends PageBase {

    protected WebDriver driver;
    protected WebActions webActions;

    public WebPageBase(WebDriver driver) throws WaitException {
        this.driver = driver;
        this.webActions = new WebActions(driver);
    }

    public HomePage navigateTo(String url) throws URLNavigationException, WaitException {
        webActions.navigateToURL(url);
        return new HomePage(driver);
    }
}
