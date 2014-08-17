package com.generic.driverinit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

	private static DesiredCapabilities capabilities;

	public static DesiredCapabilities setFirefoxCapability(Browser browser) {
		capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public static DesiredCapabilities setInternetExplorerCapability(Browser browser) {
		capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public static DesiredCapabilities setChromeCapability(Browser browser) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized", "forced-maximize-mode",
				"no-default-browser-check", "always-authorize-plugins",
				"test-type");
		capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		return capabilities;
	}

	public static DesiredCapabilities setSafariCapability(Browser browser) {
		capabilities = DesiredCapabilities.safari();
		capabilities.setBrowserName(browser.name);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setVersion(browser.version);
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public static DesiredCapabilities setAppiumCapability() {
		capabilities = new DesiredCapabilities();
		return capabilities;
	}
}
