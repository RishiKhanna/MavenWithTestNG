package com.generic.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;

import com.generic.property.mgr.PropertyManager;

public class Utilities {

	private Logger log = Logg.createLogger();
	private final static Properties frameworkProperties = PropertyManager
			.loadFrameworkPropertyFile("framework.properties");

	public static String getCurrentThreadId() {
		return "Thread:" + Thread.currentThread().getId() + "	-";
	}

	public int randomNumberGenerator() {
		log.info(Utilities.getCurrentThreadId()
				+ "Random number generator function");
		Random rand = new Random();
		log.info(Utilities.getCurrentThreadId()
				+ "Generating a random number between 0 and "
				+ frameworkProperties.getProperty("randomMaxInteger"));
		return rand.nextInt(1000);
	}

	public String convertToString(int value) {
		log.info(Utilities.getCurrentThreadId()
				+ "Integer to String Conversion function");
		log.info(Utilities.getCurrentThreadId()
				+ "Converting the Integer value " + value + " to String");
		return String.valueOf(value);
	}

	public int convertToInteger(String value) {
		log.info(Utilities.getCurrentThreadId()
				+ "String to Integer Conversion function");
		log.info(Utilities.getCurrentThreadId() + "Coverting the String value "
				+ value + " to Integer");
		return Integer.parseInt(value);
	}

	public String[] convertListToStringArray(List<?> list) {
		log.info(Utilities.getCurrentThreadId()
				+ "List to String Array Conversion function");
		log.info(Utilities.getCurrentThreadId() + "Size of the list obtained="
				+ list.size());
		Object obj[] = list.toArray();
		String str[] = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			str[i] = (String) obj[i];
		}
		return str;
	}

	public List<String> covert2DArrayToList(String array2D[][]) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				list.add(array2D[i][j]);
			}
		}
		return list;
	}
}
