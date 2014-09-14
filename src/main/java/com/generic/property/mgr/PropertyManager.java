package com.generic.property.mgr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static final Properties property = new Properties();;
	private static final String applicationPropertiesPath = "/src/test/resources/com/test/properties/";
	private static final String frameworkPropertiesPath = "/src/main/resources/com/framework/properties/";

	public static Properties loadFrameworkPropertyFile(String propertyToLoad) {
		try {
			property.load(new FileInputStream(System.getProperty("user.dir")
					+ frameworkPropertiesPath + propertyToLoad));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return property;
	}

	public static Properties loadApplicationPropertyFile(String propertyToLoad) {
		try {
			property.load(new FileInputStream(System.getProperty("user.dir")
					+ applicationPropertiesPath + propertyToLoad));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return property;
	}
}
