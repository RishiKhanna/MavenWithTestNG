package com.generic.drivers.init;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.generic.property.mgr.PropertyManager;

public class Capabilities {

	private static DesiredCapabilities capabilities;
	private static final String apkPath = "src/test/resources/com/apk";
	private final static Properties applicationProperty = PropertyManager
			.loadApplicationPropertyFile("application.properties");

	public static DesiredCapabilities setFirefoxCapability(Browser browser) {
		capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName(browser.getName());
		capabilities.setPlatform(browser.getPlatform());
		capabilities.setVersion(browser.getVersion());
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public static DesiredCapabilities setInternetExplorerCapability(
			Browser browser) {
		capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setBrowserName(browser.getName());
		capabilities.setPlatform(browser.getPlatform());
		capabilities.setVersion(browser.getVersion());
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public static DesiredCapabilities setChromeCapability(Browser browser) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized", "forced-maximize-mode",
				"no-default-browser-check", "always-authorize-plugins",
				"test-type");
		capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName(browser.getName());
		capabilities.setPlatform(browser.getPlatform());
		capabilities.setVersion(browser.getVersion());
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		return capabilities;
	}

	public static DesiredCapabilities setSafariCapability(Browser browser) {
		capabilities = DesiredCapabilities.safari();
		capabilities.setBrowserName(browser.getName());
		capabilities.setPlatform(browser.getPlatform());
		capabilities.setVersion(browser.getVersion());
		capabilities.setJavascriptEnabled(true);
		return capabilities;
	}

	public static DesiredCapabilities setAppiumCapability() {
		File appDir = new File(apkPath);
		File app = new File(appDir,
				applicationProperty.getProperty("mobileApk"));
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
				"Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				"Android");
		capabilities.setCapability(MobileCapabilityType.APP,
				app.getAbsolutePath());
		return capabilities;
	}

}
