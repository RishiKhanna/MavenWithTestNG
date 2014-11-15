package com.generic.validateorders;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.exceptions.WaitException;
import com.generic.mobile.pages.DialerPage;
import com.generic.mobile.pages.FlipkartHomePage;
import com.generic.mobile.pages.FlipkartLoginPage;
import com.generic.test.base.TestBase;
import com.generic.utilities.Reporter;

public class MobileAppTest extends TestBase {

	private FlipkartLoginPage flipkartloginPage;
	private FlipkartHomePage flipkartHomePage;
	private DialerPage dialerPage;

	@BeforeClass
	public void beforeClass(ITestContext context) throws WaitException {
		// flipkartloginPage = new
		// FlipkartLoginPage(getWebDriverInstance(context));
		dialerPage = new DialerPage(getWebDriverInstance(context));
	}

	@Test
	public void mobileTest() throws TimeoutException, WaitException,
			InterruptedException {
		
		flipkartloginPage.enterUserName("trello123@gmail.com");
		flipkartloginPage.enterPassword("telephone");
		flipkartloginPage.clickLogin(); 
		flipkartloginPage.tapMultiWidgetRoot();
		flipkartHomePage.tapAddToCart();
		Assert.assertTrue(flipkartHomePage.getNumberOfItems());
		 
		/*dialerPage.enterPhoneNumber("9975354307");
		dialerPage.addNewContact();
		dialerPage.enterFamilyName("Smith");
		dialerPage.enterGivenName("Jones");
		dialerPage.saveContact();
		dialerPage.tapDialPad();
		dialerPage.swipeToContacts(250, 100, 50, 100, 5000);
		dialerPage.changeOrientation("Landscape");
		Thread.sleep(3000);
		dialerPage.changeOrientation("Portrait");
		Thread.sleep(3000);
		Reporter.addData(new String[] { "10244", "Mobile Test", "Pass", "NA" });*/

		// dialerPage.closeApp();
	}
}
