package org.testng.driverinit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.utilities.Logg;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverInitialization {

	private static WebDriver driver = null;
	private static Logger log = Logg.createLogger();
	private static String gridAddress;
	
	private DriverInitialization() {
	}

	public static WebDriver getDriver(Browser browser, String executionType) {

		if (driver == null) {
			if ("internet explorer".equals(browser.name)) {
				log.info("**Internet Explorer Browser**");
				IEWebDriver iedriver = new IEWebDriver();
				if ("local".equals(executionType))
					driver = iedriver.getdriver(iedriver
							.getCapabilities(browser));
				else
					driver = iedriver.getRemoteDriver(gridAddress,
							iedriver.getCapabilities(browser));
			} else if ("firefox".equals(browser.name)) {
				log.info("**FireFox Browser**");
				FireFoxWebDriver ffdriver = new FireFoxWebDriver();
				if ("local".equals(executionType))
					driver = ffdriver.getdriver(ffdriver
							.getCapabilities(browser));
				else
					driver = ffdriver.getRemoteDriver(gridAddress,
							ffdriver.getCapabilities(browser));
			} else if ("chrome".equals(browser.name)) {
				log.info("**Chrome Browser**");
				ChromeWebDriver chdriver = new ChromeWebDriver();
				if ("local".equals(executionType))
					driver = chdriver.getdriver(chdriver
							.getCapabilities(browser));
				else
					driver = chdriver.getRemoteDriver(gridAddress,
							chdriver.getCapabilities(browser));
			}
		}
		log.info("Returning the instance of:" + driver.toString());
		return driver;
	}

	public static void resetDriver() {
		driver.quit();
		log.info("Resetting the instance of:" + driver.toString() + " to null");
		driver = null;
	}
}
