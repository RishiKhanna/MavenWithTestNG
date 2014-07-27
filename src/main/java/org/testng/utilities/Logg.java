package org.testng.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logg {

	// Class Instance Variables
	private static Logger _logger;
	private static String fileName = "defaultlog";

	static {
		/**
		 * This is the static block which appends the log file name with the
		 * timestamp to make it unique
		 */
		try {
			String datetimeString = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss")
					.format(new Date());
			String FileName = (fileName + "-" + datetimeString + ".log");
			File file = new File("logs/" + FileName);

			if (file.createNewFile()) {
				Properties props = new Properties();
				props.load(new FileInputStream(
						".\\src\\main\\resources\\org\\framework\\properties\\log4j.properties"));
				props.setProperty("log4j.appender.File.File", "logs/"
						+ FileName);
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				System.out.println("Preoperty log4j.appender.File.File = logs/"+ FileName);
			}
		} catch (IOException ex) {
			System.out.print("IO Exception in static method of Logger Class. "
					+ ex.getMessage());
			System.exit(-1);
		}

	}

	/**
	 * This method creates instance of the Logger class coming from log4j jar by
	 * implementing a singlteton
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