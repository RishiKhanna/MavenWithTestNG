package com.generic.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logg {

	private static Logger _logger;
	private static final String fileName = "defaultlog";
	private static final String dateAndTimeFormat = "MM-dd-yyyy_hh.mm.ss";
	private static final String logProperttFilePath = "./src/main/resources/com/framework/properties/log4j.properties";

	static {
		/**
		 * This is the static block which appends the log file name with the
		 * timestamp to make it unique
		 */
		try {
			String dateTime = DateAndTime
					.getFormattedCurrentDateAndTime(dateAndTimeFormat);
			String FileName = fileName + "-" + dateTime + ".log";
			File file = new File("logs/" + FileName);

			if (file.createNewFile()) {
				Properties props = new Properties();
				props.load(new FileInputStream(logProperttFilePath));
				props.setProperty("log4j.appender.File.File", "logs/"
						+ FileName);
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				System.out.println("Property log4j.appender.File.File = logs/"
						+ FileName);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.print("IO Exception in static method of Logger Class. "
					+ ex.getMessage());
			System.exit(-1);
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
		if (_logger == null) {
			_logger = Logger.getLogger(Logg.class);
			return _logger;
		} else
			return _logger;
	}
}