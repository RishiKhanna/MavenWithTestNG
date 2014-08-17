package com.generic.validateorders;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.pages.ConfirmationPage;
import com.generic.pages.HomePage;
import com.generic.testbase.TestBase;
import com.generic.utilities.Reporter;

public class ApplicationTest extends TestBase {

	private HomePage homePage;
	private ConfirmationPage confirmationPage;

	@BeforeClass
	public void beforeClass(ITestContext context) throws InterruptedException {
		homePage = new HomePage(getWebDriverInstance(context));
	}

	@Test(dataProvider = "ReadExcel")
	public void enterUniversityData(String lastName, String firstName,
			String address1, String address2, String city, String state,
			String pincode, String underGradProgOfInterest,
			String underGradCertOfInterest, String gradProgOfInterest,
			String gradCertOfInterest, String areaCode,
			String firstThreeDigits, String lastFourDigits, String emailId,
			String verifyEmail) throws Exception {
		try {
			homePage.enterLastName(lastName);
			homePage.enterFirstName(firstName);
			homePage.enterAddress1(address1);
			homePage.enterAddress2(address2);
			homePage.enterCity(city);
			homePage.enterState(state);
			homePage.enterZip(pincode);
			homePage.selectUnderGradProgOfInterest(underGradProgOfInterest);
			homePage.selectUnderGradCertOfInterest(underGradCertOfInterest);
			homePage.selectGradProgOfInterest(gradProgOfInterest);
			homePage.selectGradCertOfInterest(gradCertOfInterest);
			homePage.enterPhoneAreaCode(areaCode);
			homePage.enterPhoneFirstThreeDigits(firstThreeDigits);
			homePage.enterPhoneLastFourDigits(lastFourDigits);
			homePage.enterEmail(emailId);
			homePage.enterVerifyEmail(verifyEmail);
			confirmationPage = homePage.clickSubmit();
		} catch (Exception excetion) {
			logErrorMessage(excetion);
			Reporter.sendStatusToReport("UniversityForm", "134",
					"Validate confirmation message", "Fail",
					excetion.getLocalizedMessage());
			throw excetion;
		} 
	}

	@Test()
	public void validateConfirmationMessage() throws Exception {
		try {
			if(confirmationPage==null)
				throw new SkipException("Confirmation Page not initialized");
			Assert.assertTrue(confirmationPage
					.validateConfirmationMessage("test class"));
			Reporter.sendStatusToReport("UniversityForm", "134",
					"Validate confirmation message", "Pass", "NA");
		} catch (AssertionError ae) {
			logErrorMessage(ae);
			Reporter.sendStatusToReport("UniversityForm", "134",
					"Validate confirmation message", "Fail", ae.getLocalizedMessage());
			Assert.fail();
		}
		catch (Exception excetion) {
			logErrorMessage(excetion);
			Reporter.sendStatusToReport("UniversityForm", "134",
					"Validate confirmation message", "Fail",
					excetion.getLocalizedMessage());
			throw excetion;
		} 
	}

	@Test
	public void checkMethod() {
		System.out.println("--------------------------hello------------------------------");
	}
}
