package com.generic.drivers.init;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebCapabilities {

    private static DesiredCapabilities capabilities;

    private WebCapabilities() {
    }

    public static DesiredCapabilities setFirefoxCapability(Browser browser) {
        capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName(browser.getName());
        capabilities.setPlatform(browser.getPlatform());
        capabilities.setVersion(browser.getVersion());
        capabilities.setJavascriptEnabled(true);
        return capabilities;
    }

    public static DesiredCapabilities setInternetExplorerCapability(Browser browser) {
        capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setBrowserName(browser.getName());
        capabilities.setPlatform(browser.getPlatform());
        capabilities.setVersion(browser.getVersion());
        capabilities.setJavascriptEnabled(true);
        return capabilities;
    }

    public static DesiredCapabilities setChromeCapability(Browser browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "forced-maximize-mode", "no-default-browser-check",
                "always-authorize-plugins", "test-type");
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
}
