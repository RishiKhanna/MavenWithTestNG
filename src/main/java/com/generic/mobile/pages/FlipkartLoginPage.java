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
		Assert.assertTrue(action.getVisibiltyOfElementLocatedBy(byUsername));
	}

	public FlipkartLoginPage enterUserName(String username) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, byUsername, username);
		return this;
	}

	public FlipkartLoginPage enterPassword(String password) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, byPassword, password);
		return this;
	}

	public FlipkartLoginPage clickLogin() throws TimeoutException, WaitException {
		action.click(VISIBILITY, byLogin);
		return this;
	}

	public FlipkartHomePage tapMultiWidgetRoot() throws TimeoutException, WaitException {
		action.tap(VISIBILITY,byMultiWidgetRoot);
		return new FlipkartHomePage(driver);
	}
}
