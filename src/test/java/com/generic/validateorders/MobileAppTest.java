package com.generic.validateorders;

import org.openqa.selenium.TimeoutException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.exceptions.WaitException;
import com.generic.mobile.pages.FlipkartHomePage;
import com.generic.mobile.pages.FlipkartLoginPage;
import com.generic.test.base.TestBase;


public class MobileAppTest extends TestBase {

	private FlipkartLoginPage flipkartloginPage;
	private FlipkartHomePage flipkartHomePage;

	@BeforeClass
	public void beforeClass(ITestContext context) throws WaitException {
		flipkartloginPage = new FlipkartLoginPage(getWebDriverInstance(context));
	}

	@Test
	public void mobileTest() throws TimeoutException, WaitException, InterruptedException {
		flipkartloginPage.enterUserName("trello123@gmail.com");
		flipkartloginPage.enterPassword("telephone");
		flipkartloginPage.clickLogin();
		flipkartHomePage = flipkartloginPage.tapMultiWidgetRoot();
		flipkartHomePage.clickAddToCart();
		Thread.sleep(90000);
	}

}
