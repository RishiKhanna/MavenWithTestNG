package org.testng.pages;

import static org.testng.pages.locators.ConfirmationPageLocators.*;

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
