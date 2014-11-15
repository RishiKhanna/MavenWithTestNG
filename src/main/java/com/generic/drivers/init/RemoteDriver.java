package com.generic.drivers.init;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.generic.property.mgr.PropertyManager;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class RemoteDriver implements IDriver {

    private static final Logger LOGGER = Logg.createLogger();
    private static final Properties FRAMEWORKPROPERTY = PropertyManager
            .loadFrameworkPropertyFile("framework.properties");
    private static final String HUBADDRESS = FRAMEWORKPROPERTY.getProperty("gridURL");
    private static final String HUBPORT = FRAMEWORKPROPERTY.getProperty("gridPort");

    public WebDriver getDriver(Browser browser) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = null;
        try {
            if ("internet explorer".equals(browser.getName())) {
                LOGGER.info(Utilities.getCurrentThreadId() + "**Remote Internet Explorer Browser**");
                capabilities = WebCapabilities.setInternetExplorerCapability(browser);
            } else if ("firefox".equals(browser.getName())) {
                LOGGER.info(Utilities.getCurrentThreadId() + "**Remote FireFox Browser**");
                capabilities = WebCapabilities.setFirefoxCapability(browser);
            } else if ("chrome".equals(browser.getName())) {
                LOGGER.info(Utilities.getCurrentThreadId() + "**Remote Chrome Browser**");
                capabilities = WebCapabilities.setChromeCapability(browser);
            }
            driver = new RemoteWebDriver(
                    new URL("http://" + HUBADDRESS + ":" + HUBPORT + "/wd/hub"), capabilities);
            LOGGER.info(Utilities.getCurrentThreadId() + "Returning the remote instance of:"
                    + driver);
        } catch (MalformedURLException me) {
            LOGGER.info(
                    "MalformedURLException in the getDriver() method of the RemoteDriver class", me);
        }
        return driver;
    }
}
