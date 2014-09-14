package com.generic.web.pages;

import static com.generic.web.pages.locators.ConfirmationPageLocators.*;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.exceptions.WaitException;
import com.generic.page.base.WebPageBase;

public class ConfirmationPage extends WebPageBase {

	public ConfirmationPage(WebDriver driver) throws WaitException {
		super(driver);
		Assert.assertTrue(action.getVisibiltyOfElementLocatedBy(confirmMessage));
	}
	
	public boolean validateConfirmationMessage(String confirmationMsg) throws TimeoutException, WaitException {
		String actual = action.getText(VISIBILITY, confirmMessage);
		return compare.comparePartialText(actual, confirmationMsg);
	}
}

