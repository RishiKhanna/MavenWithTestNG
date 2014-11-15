package com.generic.property.mgr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.generic.utilities.Logg;

public class PropertyManager {

    private static final Properties PROPERTY = new Properties();
    private static final String APPLICATIONPROPERTIESPATH = "/src/test/resources/com/test/properties/";
    private static final String FRAMEWORKPROPERTIESPATH = "/src/main/resources/com/framework/properties/";
    private static final Logger LOGGER = Logg.createLogger();

    private PropertyManager() {
    }

    public static Properties loadFrameworkPropertyFile(String propertyToLoad) {
        try {
            PROPERTY.load(new FileInputStream(System.getProperty("user.dir")
                    + FRAMEWORKPROPERTIESPATH + propertyToLoad));
        } catch (IOException io) {
            LOGGER.info(
                    "IOException in the loadFrameworkPropertyFile() method of the PropertyManager class",
                    io);
            Runtime.getRuntime().halt(0);
        }
        return PROPERTY;
    }

    public static Properties loadApplicationPropertyFile(String propertyToLoad) {
        try {
            PROPERTY.load(new FileInputStream(System.getProperty("user.dir")
                    + APPLICATIONPROPERTIESPATH + propertyToLoad));
        } catch (IOException io) {
            LOGGER.info(
                    "IOException in the loadFrameworkPropertyFile() method of the PropertyManager class",
                    io);
            Runtime.getRuntime().halt(0);
        }
        return PROPERTY;
    }
}
