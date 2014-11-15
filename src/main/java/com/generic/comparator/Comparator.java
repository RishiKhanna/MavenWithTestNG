package com.generic.comparator;

import org.apache.log4j.Logger;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class Comparator {

    private static final Logger LOGGER = Logg.createLogger();

    public boolean compareExactText(String actual, String expected) {
        
        int a[] = {1,2,3};
        
        
        LOGGER.info(Utilities.getCurrentThreadId() + "Actual Value=" + actual + " Expected Value="
                + expected);
        LOGGER.info(Utilities.getCurrentThreadId() + "Result of exact comparison is "
                + actual.equals(expected));
        return actual.equals(expected);
    }

    public boolean comparePartialText(String actual, String expected) {
        LOGGER.info(Utilities.getCurrentThreadId() + "Actual Value=" + actual + " Expected Value="
                + expected);
        LOGGER.info(Utilities.getCurrentThreadId() + "Result of partial comparison is "
                + actual.contains(expected));
        return actual.contains(expected);
    }
}
