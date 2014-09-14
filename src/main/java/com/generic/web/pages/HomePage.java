package com.generic.web.pages;

import static com.generic.web.pages.locators.HomePageLocators.*;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.generic.exceptions.WaitException;
import com.generic.page.base.WebPageBase;

public class HomePage extends WebPageBase {

	public HomePage(WebDriver driver) throws WaitException {
		super(driver);
		Assert.assertTrue(action.getVisibiltyOfElementLocatedBy(lastName));
	}
	
	public HomePage enterLastName(String lastNameVal) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, lastName, lastNameVal);
		return this;
	}

	public HomePage enterFirstName(String firstNameVal)
			throws TimeoutException, WaitException {
		action.enterText(VISIBILITY, firstName, firstNameVal);
		return this;
	}

	public HomePage enterAddress1(String address1Val) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, address1, address1Val);
		return this;
	}

	public HomePage enterAddress2(String address2Val) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, address2, address2Val);
		return this;
	}

	public HomePage enterCity(String cityVal) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, city, cityVal);
		return this;
	}

	public HomePage enterState(String stateVal) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, state, stateVal);
		return this;
	}

	public HomePage enterZip(String zipVal) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, zip, zipVal);
		return this;
	}

	public HomePage selectUnderGradProgOfInterest(
			String underGradProgOfInterestVal) throws TimeoutException,
			WaitException {
		action.selectFromDropDown(VISIBILITY, underGradProgOfInterest,
				underGradProgOfInterestVal);
		return this;
	}

	public HomePage selectUnderGradCertOfInterest(
			String underGradCertOfInterestVal) throws TimeoutException,
			WaitException {
		action.selectFromDropDown(VISIBILITY, underGradCertOfInterest,
				underGradCertOfInterestVal);
		return this;
	}

	public HomePage selectGradProgOfInterest(String gradProgOfInterestVal)
			throws TimeoutException, WaitException {
		action.selectFromDropDown(VISIBILITY, gradProgOfInterest,
				gradProgOfInterestVal);
		return this;
	}

	public HomePage selectGradCertOfInterest(String gradCertOfInterestVal)
			throws TimeoutException, WaitException {
		action.selectFromDropDown(VISIBILITY, gradCertOfInterest,
				gradCertOfInterestVal);
		return this;
	}

	public HomePage enterPhoneAreaCode(String phAreadCodeVal)
			throws TimeoutException, WaitException {
		action.enterText(VISIBILITY, phAreadCode, phAreadCodeVal);
		return this;
	}

	public HomePage enterPhoneFirstThreeDigits(String phFirstThreeVal)
			throws TimeoutException, WaitException {
		action.enterText(VISIBILITY, phFirstThree, phFirstThreeVal);
		return this;
	}

	public HomePage enterPhoneLastFourDigits(String phLastFourVal)
			throws TimeoutException, WaitException {
		action.enterText(VISIBILITY, phLastFour, phLastFourVal);
		return this;
	}

	public HomePage enterEmail(String emailVal) throws TimeoutException,
			WaitException {
		action.enterText(VISIBILITY, email, emailVal);
		return this;
	}

	public HomePage enterVerifyEmail(String verifyEmailVal)
			throws TimeoutException, WaitException {
		action.enterText(VISIBILITY, verifyEmail, verifyEmailVal);
		return this;
	}

	public ConfirmationPage clickSubmit() throws TimeoutException,
			WaitException {
		action.click(VISIBILITY, submit);
		return new ConfirmationPage(driver);
	}

	public ConfirmationPage enterFormDetails(String lastName, String firstName,
			String address1, String address2, String city, String state,
			String pincode, String underGradProgOfInterest,
			String underGradCertOfInterest, String gradProgOfInterest,
			String gradCertOfInterest, String areaCode,
			String firstThreeDigits, String lastFourDigits, String emailId,
			String verifyEmail) throws TimeoutException, WaitException, InterruptedException {
		enterLastName(lastName);
		enterFirstName(firstName);
		enterAddress1(address1);
		enterAddress2(address2);
		enterCity(city);
		enterState(state);
		enterZip(pincode);
		Thread.sleep(10000);
		selectUnderGradProgOfInterest(underGradProgOfInterest);
		selectUnderGradCertOfInterest(underGradCertOfInterest);
		selectGradProgOfInterest(gradProgOfInterest);
		selectGradCertOfInterest(gradCertOfInterest);
		enterPhoneAreaCode(areaCode);
		enterPhoneFirstThreeDigits(firstThreeDigits);
		enterPhoneLastFourDigits(lastFourDigits);
		enterEmail(emailId);
		enterVerifyEmail(verifyEmail);
		return clickSubmit();
	}
}
