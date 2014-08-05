package com.generic.driverinit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInitialization {

	private static Logger log = Logg.createLogger();

	private DriverInitialization() {
	}

	public static WebDriver getDriver(Browser browser) {
		WebDriver driver = null;
		if ("internet explorer".equals(browser.name)) {
			log.info(Utilities.getCurrentThreadId()
					+ "**Internet Explorer Browser**");
			InternetExplorerWebDriver iedriver = new InternetExplorerWebDriver();
			driver = iedriver.getdriver(iedriver.getCapabilities(browser));
		} else if ("firefox".equals(browser.name)) {
			log.info(Utilities.getCurrentThreadId() + "**FireFox Browser**");
			FireFoxWebDriver ffdriver = new FireFoxWebDriver();
			driver = ffdriver.getdriver(ffdriver.getCapabilities(browser));
		} else if ("chrome".equals(browser.name)) {
			log.info(Utilities.getCurrentThreadId() + "**Chrome Browser**");
			ChromeWebDriver chdriver = new ChromeWebDriver();
			driver = chdriver.getdriver(chdriver.getCapabilities(browser));
		}
		log.info(Utilities.getCurrentThreadId()
				+ "Returning the local instance of:" + driver.toString());
		return driver;
	}

	public static WebDriver getRemoteDriver(Browser browser, Grid grid) {
		WebDriver driver = null;
		if (driver == null) {
			if ("internet explorer".equals(browser.name)) {
				log.info(Utilities.getCurrentThreadId()
						+ "**Remote Internet Explorer Browser**");
				InternetExplorerWebDriver iedriver = new InternetExplorerWebDriver();
				driver = iedriver.getremotedriver(grid,
						iedriver.getCapabilities(browser));
			} else if ("firefox".equals(browser.name)) {
				log.info(Utilities.getCurrentThreadId()
						+ "**Remote FireFox Browser**");
				FireFoxWebDriver ffdriver = new FireFoxWebDriver();
				driver = ffdriver.getremotedriver(grid,
						ffdriver.getCapabilities(browser));
			} else if ("chrome".equals(browser.name)) {
				log.info(Utilities.getCurrentThreadId()
						+ "**Remote Chrome Browser**");
				ChromeWebDriver chdriver = new ChromeWebDriver();
				driver = chdriver.getremotedriver(grid,
						chdriver.getCapabilities(browser));
			}
		}
		log.info(Utilities.getCurrentThreadId()
				+ "Returning the remote instance of:" + driver.toString());
		return driver;
	}
}
