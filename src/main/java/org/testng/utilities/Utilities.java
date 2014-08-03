package org.testng.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.propertymgr.PropertyManager;

public class Utilities {

	private Logger log = Logg.createLogger();
	private final static Properties frameworkProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/org/framework/properties/framework.properties");

	public int randomNumberGenerator() {
		log.info("Random number generator function");
		Random rand = new Random();
		log.info("Generating a random number between 0 and "
				+ frameworkProperties.getProperty("randomMaxInteger"));
		return rand.nextInt(1000);
	}

	public String convertToString(int value) {
		log.info("Integer to String Conversion function");
		log.info("Coverting the Integer value " + value + " to String");
		return String.valueOf(value);
	}

	public int convertToInteger(String value) {
		log.info("String to Integer Conversion function");
		log.info("Coverting the String value " + value + " to Integer");
		return Integer.parseInt(value);
	}

	public String[] convertListToStringArray(List<?> list) {
		log.info("List to String Array Conversion function");
		log.info("Size of the list obtained=" + list.size());
		Object obj[] = list.toArray();
		String str[] = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			str[i] = (String) obj[i];
		}
		return str;
	}

	public List<String> covert2DArrayToList(String array2D[][]) {
		List<String> list =new ArrayList<String>();		
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				list.add(array2D[i][j]);
			}
		}
		return list;
	}
}
