package com.generic.validateorders;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.exceptions.WaitException;
import com.generic.page.base.WebPageBase;
import com.generic.test.base.TestBase;
import com.generic.utilities.Reporter;
import com.generic.utilities.Utilities;
import com.generic.web.pages.ConfirmationPage;
import com.generic.web.pages.HomePage;

public class WebAppTest extends TestBase {

	private HomePage homePage;
	private ConfirmationPage confirmationPage;
	private WebPageBase pageBase;


	@BeforeClass
	public void beforeClass(ITestContext context) throws WaitException {
		pageBase = new WebPageBase(getWebDriverInstance(context));
	}

	@Test(dataProvider = "ReadExcel")
	public void enterAndValidateUniversityData(String lastName,
			String firstName, String address1, String address2, String city,
			String state, String pincode, String underGradProgOfInterest,
			String underGradCertOfInterest, String gradProgOfInterest,
			String gradCertOfInterest, String areaCode,
			String firstThreeDigits, String lastFourDigits, String emailId,
			String verifyEmail) throws Exception {
		try {
			homePage = pageBase.navigateTo(applicationProperty
					.getProperty("applicationURL"));
			Thread.sleep(5000);
			confirmationPage = homePage.enterFormDetails(lastName, firstName,
					address1, address2, city, state, pincode,
					underGradProgOfInterest, underGradCertOfInterest,
					gradProgOfInterest, gradCertOfInterest, areaCode,
					firstThreeDigits, lastFourDigits, emailId, verifyEmail);
			Assert.assertFalse(confirmationPage
					.validateConfirmationMessage("test class"));
			Reporter.sendStatusToReport("UniversityForm", "134",
					Utilities.getCurrentThreadId()
							+ "Validate confirmation message", "Pass", "NA");
		} catch (Exception exception) {
			logErrorMessage(exception);
			Reporter.sendStatusToReport("UniversityForm", "134",
					Utilities.getCurrentThreadId()
							+ "Validate confirmation message", "Fail",
					exception.getLocalizedMessage());
			throw exception;
		}
	}
}
