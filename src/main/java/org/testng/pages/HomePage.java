package org.testng.pages;

import static org.testng.pages.locators.HomePageLocators.*;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage enterLastName(String lastNameVal) {
		action.enterText(VISIBILITY, lastName, lastNameVal);
		return this;
	}

	public HomePage enterFirstName(String firstNameVal) {
		action.enterText(VISIBILITY, firstName, firstNameVal);
		return this;
	}

	public HomePage enterAddress1(String address1Val) {
		action.enterText(VISIBILITY, address1, address1Val);
		return this;
	}

	public HomePage enterAddress2(String address2Val) {
		action.enterText(VISIBILITY, address2, address2Val);
		return this;
	}

	public HomePage enterCity(String cityVal) {
		action.enterText(VISIBILITY, city, cityVal);
		return this;
	}

	public HomePage enterState(String stateVal) {
		action.enterText(VISIBILITY, state, stateVal);
		return this;
	}

	public HomePage enterZip(String zipVal) {
		action.enterText(VISIBILITY, zip, zipVal);
		return this;
	}

	public HomePage selectUnderGradProgOfInterest(
			String underGradProgOfInterestVal) {
		action.selectFromDropDown(VISIBILITY, underGradProgOfInterest,
				underGradProgOfInterestVal);
		return this;
	}

	public HomePage selectUnderGradCertOfInterest(
			String underGradCertOfInterestVal) {
		action.selectFromDropDown(VISIBILITY, underGradCertOfInterest,
				underGradCertOfInterestVal);
		return this;
	}

	public HomePage selectGradProgOfInterest(String gradProgOfInterestVal) {
		action.selectFromDropDown(VISIBILITY, gradProgOfInterest,
				gradProgOfInterestVal);
		return this;
	}

	public HomePage selectGradCertOfInterest(String gradCertOfInterestVal) {
		action.selectFromDropDown(VISIBILITY, gradCertOfInterest,
				gradCertOfInterestVal);
		return this;
	}

	public HomePage enterPhoneAreaCode(String phAreadCodeVal) {
		action.enterText(VISIBILITY, phAreadCode, phAreadCodeVal);
		return this;
	}

	public HomePage enterPhoneFirstThreeDigits(String phFirstThreeVal) {
		action.enterText(VISIBILITY, phFirstThree, phFirstThreeVal);
		return this;
	}

	public HomePage enterPhoneLastFourDigits(String phLastFourVal) {
		action.enterText(VISIBILITY, phLastFour, phLastFourVal);
		return this;
	}

	public HomePage enterEmail(String emailVal) {
		action.enterText(VISIBILITY, email, emailVal);
		return this;
	}

	public HomePage enterVerifyEmail(String verifyEmailVal) {
		action.enterText(VISIBILITY, verifyEmail, verifyEmailVal);
		return this;
	}

	public ConfirmationPage clickSubmit() {
		action.click(VISIBILITY, submit);
		return new ConfirmationPage(driver);
	}
}

