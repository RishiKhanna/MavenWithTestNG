package com.generic.driverinit;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class ChromeWebDriver extends IDriver {
	private static Logger log = Logg.createLogger();

	protected void setPath() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/com/drivers/chromedriver.exe");
	}

	public WebDriver getdriver(Capabilities capabilities) {
		setPath();
		log.info(Utilities.getCurrentThreadId()
				+ "Instantiating/Launching the Chrome Browser");
		return new ChromeDriver(capabilities);
	}

	public Capabilities getCapabilities(Browser browser) {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized", "forced-maximize-mode",
                "no-default-browser-check", "always-authorize-plugins","test-type");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		return capabilities;
	}

	public WebDriver getremotedriver(Grid grid, Capabilities capabilities) {
		WebDriver driver = null;
		log.info(Utilities.getCurrentThreadId()
				+ "Instantiating/Launching the Chrome Browser on Remote Node");
		try {
			driver = new RemoteWebDriver(new URL("http://" + grid.gridAddress
					+ ":" + grid.portNumber + "/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
