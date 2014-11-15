package com.generic.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logg {

    private static Logger LOGGER;
    private static final String FILENAME = "defaultlog";
    private static final String DATEANDTIMEFORMAT = "MM-dd-yyyy_hh.mm.ss";
    private static final String LOGPROPERTTFILEPATH = "./src/main/resources/com/framework/properties/log4j.properties";

    private Logg() {
    }

    static {
        /**
         * This is the static block which appends the log file name with the
         * timestamp to make it unique
         */
        try {
            String dateTime = DateAndTime.getFormattedCurrentDateAndTime(DATEANDTIMEFORMAT);
            String FileName = FILENAME + "-" + dateTime + ".log";
            File file = new File("logs/" + FileName);
            if (file.createNewFile()) {
                Properties props = new Properties();
                props.load(new FileInputStream(LOGPROPERTTFILEPATH));
                props.setProperty("log4j.appender.File.File", "logs/" + FileName);
                LogManager.resetConfiguration();
                PropertyConfigurator.configure(props);
                System.out.println("Property log4j.appender.File.File = logs/" + FileName);
            } else {
                System.out.println("File aready exists");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Exception in static method of Logger Class. ", ex);
        }

    }

    /**
     * This method creates instance of the Logger class coming from log4j jar by
     * implementing a singelton
     * 
     * @return _logger - new instance if no instance exist else an existing
     *         instance if the method is invoked previously
     */
    public static Logger createLogger() {
        if (LOGGER == null) {
            LOGGER = LogManager.getLogger(Logg.class);
            return LOGGER;
        } else {
            return LOGGER;
        }
    }
}