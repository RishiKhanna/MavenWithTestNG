package com.generic.drivers.init;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class MobileDriver implements IDriver {
	private static Logger log = Logg.createLogger();

	public WebDriver getDriver(Browser browser) {
		WebDriver driver = null;
		DesiredCapabilities capabilities = Capabilities.setAppiumCapability();
		try {
			log.info(Utilities.getCurrentThreadId() + "**Mobile Driver**");
			log.info(Utilities.getCurrentThreadId()
					+ "Instantiating the Appium Driver");
			driver = new AppiumDriver(new URL("http://" + "127.0.0.1" + ":"
					+ "4723" + "/wd/hub"), capabilities);
			log.info(Utilities.getCurrentThreadId()
					+ "Returning the mobile instance of:" + driver);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}