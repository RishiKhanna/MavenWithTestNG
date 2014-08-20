package com.generic.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;


public class DateAndTime {
	private static Logger log = Logg.createLogger();

	/**
	 * This method generates the Current Time in the milli seconds
	 * using the System Class
	 * 
	 * @return long - current time in milli seconds
	 */
	public static long getCurrentTimeInMillis() {
		long timeInMillis = 0;
		try {
			timeInMillis = System.currentTimeMillis();
			log.info("Current Time in millis is "+timeInMillis);
		} catch (Exception ex) {
			log.error("Exception in getCurrentTimeInMillis() method of DateAndTime Class "
					+ ex.getMessage());
		}
		return timeInMillis;
	}

	/**
	 * This method generates the Current Date And Time in the default format
	 * using the Date Object
	 * 
	 * @return String- string of Current Date And Time
	 */
	public static String getCurrentDateAndTime() {
		String dateTime = null;
		try {
			dateTime = new Date().toString();
			log.info("Current Date and Time is " + dateTime);
		} catch (Exception ex) {
			log.error("Exception in getCurrentDateAndTime() method of DateAndTime Class "
					+ ex.getMessage());
			return null;
		}
		return dateTime;
	}

	/**
	 * This method generates formatted Current Date And Time using the Date
	 * Object and SimpleDateFormat class
	 * 
	 * @param format
	 *            - string set by the User
	 * @return String- string of Current Date And Time formatted as per the user
	 */
	public static String getFormattedCurrentDateAndTime(String format) {
		String formattedDateTime = null;
		try {
			formattedDateTime = new SimpleDateFormat(format).format(new Date());
			log.info("Formatted(" + format + ")Current Date and Time is "
					+ formattedDateTime);

		} catch (Exception ex) {
			log.error("Exception in getFormattedCurrentDateAndTime() method of DateAndTime Class "
					+ ex.getMessage());
			return null;
		}
		return formattedDateTime;
	}
}
