package com.generic.drivers.init;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.generic.property.mgr.PropertyManager;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class MobileDriver implements IDriver {
    private static final Properties FRAMEWORKPROPERTY = PropertyManager
            .loadFrameworkPropertyFile("framework.properties");
    private static final Logger LOGGER = Logg.createLogger();
    private static final String APPIUMSERVER = FRAMEWORKPROPERTY.getProperty("appiumServerIP");
    private static final String APPIUMPORT = FRAMEWORKPROPERTY.getProperty("appiumServerPort");

    public WebDriver getDriver(Browser browser) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = MobileCapabilities.setAppiumNativeAppCapability();
        try {
            LOGGER.info(Utilities.getCurrentThreadId() + "**Mobile Driver**");
            LOGGER.info(Utilities.getCurrentThreadId() + "Instantiating the Appium Driver");
            driver = new AppiumDriver(new URL("http://" + APPIUMSERVER + ":" + APPIUMPORT
                    + "/wd/hub"), capabilities);
            LOGGER.info(Utilities.getCurrentThreadId() + "Returning the mobile instance of:"
                    + driver);
        } catch (MalformedURLException me) {
            LOGGER.info(
                    "MalformedURLException in the getDriver() method of the MobileDriver class", me);
        }
        return driver;
    }
}