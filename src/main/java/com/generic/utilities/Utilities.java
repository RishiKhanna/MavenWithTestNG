package com.generic.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.apache.log4j.Logger;
import com.generic.property.mgr.PropertyManager;

public class Utilities {

    private static final Logger LOGGER = Logg.createLogger();
    private static final Properties FRAMEWORKPROPERTIES = PropertyManager
            .loadFrameworkPropertyFile("framework.properties");

    public static String getCurrentThreadId() {
        return "Thread:" + Thread.currentThread().getId() + "	-";
    }

    public int randomNumberGenerator() {
        LOGGER.info(Utilities.getCurrentThreadId() + "Random number generator function");
        Random rand = new Random();
        LOGGER.info(Utilities.getCurrentThreadId() + "Generating a random number between 0 and "
                + FRAMEWORKPROPERTIES.getProperty("randomMaxInteger"));
        return rand.nextInt(1000);
    }

    public String convertToString(int value) {
        LOGGER.info(Utilities.getCurrentThreadId() + "Integer to String Conversion function");
        LOGGER.info(Utilities.getCurrentThreadId() + "Converting the Integer value " + value
                + " to String");
        return String.valueOf(value);
    }

    public int convertToInteger(String value) {
        LOGGER.info(Utilities.getCurrentThreadId() + "String to Integer Conversion function");
        LOGGER.info(Utilities.getCurrentThreadId() + "Coverting the String value " + value
                + " to Integer");
        return Integer.parseInt(value);
    }

    public String[] convertListToStringArray(List<?> list) {
        LOGGER.info(Utilities.getCurrentThreadId() + "List to String Array Conversion function");
        LOGGER.info(Utilities.getCurrentThreadId() + "Size of the list obtained=" + list.size());
        Object[] obj = list.toArray();
        String[] str = new String[obj.length];
        for (int i = 0; i < obj.length; i++) {
            str[i] = (String) obj[i];
        }
        return str;
    }

    public List<String> covert2DArrayToList(String[][] array2D) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                list.add(array2D[i][j]);
            }
        }
        return list;
    }
}
