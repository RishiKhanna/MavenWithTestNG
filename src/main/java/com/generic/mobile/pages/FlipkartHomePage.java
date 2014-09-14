package com.generic.mobile.pages;

import static com.generic.mobile.locators.FlipkartHomePageLocators.*;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.exceptions.WaitException;
import com.generic.page.base.MobilePageBase;

public class FlipkartHomePage extends MobilePageBase {

	public FlipkartHomePage(WebDriver driver) throws WaitException {
		super(driver);
		Assert.assertTrue(action.getVisibiltyOfElementLocatedBy(byCartButton));
	}

	public FlipkartHomePage getSearchBoxText() throws TimeoutException,
			WaitException {
		action.getText(VISIBILITY, bySearchText);
		return this;
	}

	public void clickAddToCart() throws TimeoutException, WaitException, InterruptedException {
		action.tap(VISIBILITY, byCartButton);
	}
}
