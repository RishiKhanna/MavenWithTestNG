package com.generic.pages;

import static com.generic.pages.locators.ConfirmationPageLocators.*;

import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends PageBase {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateConfirmationMessage(String confirmationMsg) {
		String actual = action.getText(VISIBILITY, confirmMessage);
		return compare.comparePartialText(actual, confirmationMsg);
	}
}

