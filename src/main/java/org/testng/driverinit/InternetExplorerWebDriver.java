package org.testng.driverinit;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.utilities.Logg;
import org.testng.utilities.Utilities;

public class InternetExplorerWebDriver extends IDriver {

	private static Logger log = Logg.createLogger();

	protected void setPath() {
		System.setProperty("webdriver.ie.driver",
				"./Resources/Drivers/IEDriverServer.exe");
	}

	public WebDriver getdriver(Capabilities capabilities) {
		setPath();
		log.info(Utilities.getCurrentThreadId()
				+ "Instantiating/Launching the Internet Explorer Browser");
		return new InternetExplorerDriver(capabilities);
	}

	public Capabilities getCapabilities(Browser browser) {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public WebDriver getremotedriver(Grid grid, Capabilities capabilities) {
		WebDriver driver = null;
		log.info(Utilities.getCurrentThreadId()
				+ "Intantiating/Launching the Internet Explorer Browser on Remote Node");
		try {
			driver = new RemoteWebDriver(new URL("http://" + grid.gridAddress
					+ ":" + grid.portNumber + "/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
