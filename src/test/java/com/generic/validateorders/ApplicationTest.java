package com.generic.validateorders;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.pages.ConfirmationPage;
import com.generic.pages.HomePage;
import com.generic.testbase.TestBase;

public class ApplicationTest extends TestBase {

	private HomePage homePage;
	private ConfirmationPage confirmationPage;

	@BeforeClass
	public void beforeClass(ITestContext context) throws InterruptedException {
		homePage = new HomePage((WebDriver)context.getAttribute(context.getCurrentXmlTest().getName()));
	}

	@Test
	public void enterUniversityData() throws InterruptedException {
		Random rand=new Random();
		Thread.sleep(rand.nextInt(10000));
		homePage.enterLastName("Stewart");
		homePage.enterFirstName("Jimmy");
		homePage.enterAddress1("12/13 road");
		homePage.enterAddress2("Thane");
		homePage.enterCity("Mumbai");
		homePage.enterState("Maharashtra");
		homePage.enterZip("400049");
		homePage.selectUnderGradProgOfInterest("Bachelor of Science in Information Technology");
		homePage.selectUnderGradCertOfInterest("Essentials of Information Security");
		homePage.selectGradProgOfInterest("Master of Science in Engineering Management");
		homePage.selectGradCertOfInterest("Project Management");
		homePage.enterPhoneAreaCode("033");
		homePage.enterPhoneFirstThreeDigits("765");
		homePage.enterPhoneLastFourDigits("5432");
		homePage.enterEmail("rishi.khanna@gmail.com");
		homePage.enterVerifyEmail("rishi.khanna@gmail.com");
		confirmationPage=homePage.clickSubmit();
	}
	
	@Test
	public void validateConfirmationMessage() throws InterruptedException {
		Random rand=new Random();
		Thread.sleep(rand.nextInt(10000));
		Assert.assertTrue(confirmationPage.validateConfirmationMessage("test class"));
	}
}

