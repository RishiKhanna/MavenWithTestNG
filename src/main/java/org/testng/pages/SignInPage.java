package org.testng.pages;

import static org.testng.pages.locators.SignInPageLocators.*;


public class SignInPage extends PageBase {

	public void enterUserName(String userName) {
		action.enterText(VISIBILITY, userNameLocator, userName);
	}

	public void enterPassword(String password) {
		action.enterText(VISIBILITY, passwordLocator, password);
	}

	public void clickLogin() {
		action.clickByJQuery(signInButtonLocator);
	}
}
