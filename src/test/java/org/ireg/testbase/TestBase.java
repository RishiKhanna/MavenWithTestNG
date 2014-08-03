package org.ireg.testbase;

import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.actions.BrowserActions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.driverinit.Browser;
import org.testng.driverinit.DriverInitialization;
import org.testng.driverinit.Grid;
import org.testng.propertymgr.PropertyManager;
import org.testng.utilities.ExcelRead;
import org.testng.utilities.Logg;
import org.testng.utilities.Reporter;
import org.testng.utilities.Utilities;

public class TestBase {
	private final Properties frameworkProperty = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/framework/properties/framework.properties");
	protected static Reporter report = null;
	protected final Logger log = Logg.createLogger();
	protected final static Utilities util = new Utilities();
	protected static String[][] strorage = null;
	private final Properties applicationProperty = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/test/properties/application.properties");

	@DataProvider(name = "ReadExcel")
	public String[][] readDataFromExcel(Method m) {
		log.info("Data Provider: Read Excel");
		log.info("Data Provider: Running for Method: " + m.getName());
		if ("verifyUserIsAbleToAddACustomerSuccessfully".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Customer");
			log.info("Data Provider: Retrieved data from the Customer Sheet of Test Data Excel");
		} else if ("".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Sheet2");
		}
		return strorage;
	}

	@AfterTest
	public void afterMethod(ITestContext context) throws InterruptedException {
		WebDriver webdriver = (WebDriver) context.getAttribute(context
				.getCurrentXmlTest().getName());
		context.removeAttribute(context.getCurrentXmlTest().getName());
		log.info("Closing the instance:" + webdriver.toString());
		webdriver.quit();
	}

	@BeforeTest
	public void beforeTest(ITestContext context) {
		report = new Reporter();
		report.generateReport();
		Browser browser = new Browser();
		WebDriver driver;
		if ("local".equals(frameworkProperty.getProperty("executionType"))) {
			driver = DriverInitialization.getDriver(browser);
		} else {
			Grid grid = new Grid();
			driver = DriverInitialization.getRemoteDriver(browser, grid);
		}
		context.setAttribute(context.getCurrentXmlTest().getName(), driver);
		driver.get(applicationProperty.getProperty("applicationURL"));
		driver.manage().window().maximize();
	}
}