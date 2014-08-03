package org.testng.pages;

import static org.testng.pages.locators.SignInPageLocators.*;

import org.openqa.selenium.WebDriver;

public class SignInPage extends PageBase {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

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
