package com.generic.driverinit;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class FireFoxWebDriver extends IDriver {

	private static Logger log = Logg.createLogger();

	protected void setPath() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/org/drivers/chromedriver.exe");
	}

	public WebDriver getdriver(Capabilities capabilities) {
		setPath();
		log.info(Utilities.getCurrentThreadId()
				+ "Instantiating/Launching the Firefox Browser");
		return new FirefoxDriver(capabilities);
	}

	public Capabilities getCapabilities(Browser browser) {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public WebDriver getremotedriver(Grid grid, Capabilities capabilities) {
		WebDriver driver = null;
		log.info(Utilities.getCurrentThreadId()
				+ "Instantiating/Launching the Firefox Browser on Remote node");
		try {
			driver = new RemoteWebDriver(new URL("http://" + grid.gridAddress
					+ ":" + grid.portNumber + "/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
