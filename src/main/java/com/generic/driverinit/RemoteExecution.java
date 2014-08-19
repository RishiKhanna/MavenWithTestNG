package com.generic.driverinit;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class RemoteExecution {

	private static Logger log = Logg.createLogger();

	private RemoteExecution() {
	}

	public static WebDriver getRemoteDriver(Browser browser, Grid grid) {
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		try {
			if ("internet explorer".equals(browser.getName())) {
				log.info(Utilities.getCurrentThreadId()
						+ "**Remote Internet Explorer Browser**");
				capabilities = Capabilities
						.setInternetExplorerCapability(browser);
			} else if ("firefox".equals(browser.getName())) {
				log.info(Utilities.getCurrentThreadId()
						+ "**Remote FireFox Browser**");
				capabilities = Capabilities.setFirefoxCapability(browser);
			} else if ("chrome".equals(browser.getName())) {
				log.info(Utilities.getCurrentThreadId()
						+ "**Remote Chrome Browser**");
				capabilities = Capabilities.setChromeCapability(browser);
			}
			driver = new RemoteWebDriver(new URL("http://" + grid.getGridAddress()
					+ ":" + grid.getPortNumber() + "/wd/hub"), capabilities);
			log.info(Utilities.getCurrentThreadId()
					+ "Returning the remote instance of:" + driver.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
}
