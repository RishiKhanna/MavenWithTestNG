package com.generic.testbase;

import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.generic.driverinit.Browser;
import com.generic.driverinit.DriverInitialization;
import com.generic.driverinit.Grid;
import com.generic.listeners.ReportListener;
import com.generic.propertymgr.PropertyManager;
import com.generic.utilities.ExcelRead;
import com.generic.utilities.Logg;
import com.generic.utilities.Reporter;
import com.generic.utilities.Utilities;

public class TestBase {
	private final Properties frameworkProperty = PropertyManager
			.loadFrameworkPropertyFile("framework.properties");
	protected static Reporter report = new Reporter();
	protected final Logger log = Logg.createLogger();
	protected final static Utilities util = new Utilities();
	protected static String[][] strorage = null;
	private final Properties applicationProperty = PropertyManager
			.loadApplicationPropertyFile("application.properties");
	private static int total;
	private static int pass;
	private static int fail;

	@DataProvider(name = "ReadExcel")
	public String[][] readDataFromExcel(Method m) {
		log.info(Utilities.getCurrentThreadId() + "Data Provider: Read Excel");
		log.info(Utilities.getCurrentThreadId()
				+ "Data Provider: Running for Method: " + m.getName());
		if ("enterUniversityData".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Customer");
			log.info(Utilities.getCurrentThreadId()
					+ "Data Provider: Retrieved data from the Customer Sheet of Test Data Excel");
		} else if ("".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Sheet2");
		}
		return strorage;
	}

	@BeforeTest
	public void beforeTest(ITestContext context) {
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

	@AfterTest
	public void afterMethod(ITestContext context) throws InterruptedException {
		WebDriver webdriver = (WebDriver) context.getAttribute(context
				.getCurrentXmlTest().getName());
		log.info(Utilities.getCurrentThreadId() + "Closing the instance:"
				+ webdriver.toString());
		webdriver.quit();
		context.removeAttribute(context.getCurrentXmlTest().getName());
		total = total + context.getPassedTests().size()
				+ context.getFailedTests().size();
		pass = pass + context.getPassedTests().size();
		fail = fail + context.getFailedTests().size();
	}

	@AfterSuite
	public void afteSuite() { 
		/*int failed = ReportListener.getFailedResults();
		int passed = ReportListener.getPassedResults();
		int skipped = ReportListener.getSkippedResults();
		int total = failed+skipped+passed;
		Reporter.sendFinalCountToReport(String.valueOf(total),String.valueOf(passed),String.valueOf(failed));*/
	}
}