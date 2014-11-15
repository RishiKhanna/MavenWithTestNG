package com.generic.drivers.init;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class LocalDriver implements IDriver {

    private static final Logger LOGGER = Logg.createLogger();

    public WebDriver getDriver(Browser browser) {
        WebDriver driver = null;
        if ("internet explorer".equals(browser.getName())) {
            LOGGER.info(Utilities.getCurrentThreadId() + "**Internet Explorer Browser**");
            System.setProperty("webdriver.ie.driver",
                    "src/main/resources/com/drivers/IEDriverServer.exe");
            DesiredCapabilities capabilities = WebCapabilities
                    .setInternetExplorerCapability(browser);
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Instantiating/Launching the Internet Explorer Browser");
            driver = new InternetExplorerDriver(capabilities);
        } else if ("firefox".equals(browser.getName())) {
            LOGGER.info(Utilities.getCurrentThreadId() + "**FireFox Browser**");
            DesiredCapabilities capabilities = WebCapabilities.setFirefoxCapability(browser);
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Instantiating/Launching the Firefox Browser");
            driver = new FirefoxDriver(capabilities);
        } else if ("chrome".equals(browser.getName())) {
            LOGGER.info(Utilities.getCurrentThreadId() + "**Chrome Browser**");
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/com/drivers/chromedriver.exe");
            DesiredCapabilities capabilities = WebCapabilities.setChromeCapability(browser);
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Instantiating/Launching the Chrome Browser");
            driver = new ChromeDriver(capabilities);
        }
        LOGGER.info(Utilities.getCurrentThreadId() + "Returning the local instance of:"
                + driver.toString());
        return driver;
    }
}
