package com.generic.actions;

import org.apache.log4j.Logger;

import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class Comparator {

	private final Logger log = Logg.createLogger();

	public boolean compareExactText(String actual, String expected) {
		log.info(Utilities.getCurrentThreadId() + "Actual Value=" + actual
				+ " Expected Value=" + expected);
		log.info(Utilities.getCurrentThreadId()
				+ "Result of exact comparison is " + actual.equals(expected));
		return actual.equals(expected);
	}

	public boolean comparePartialText(String actual, String expected) {
		log.info(Utilities.getCurrentThreadId() + "Actual Value=" + actual
				+ " Expected Value=" + expected);
		log.info(Utilities.getCurrentThreadId()
				+ "Result of partial comparison is "
				+ actual.contains(expected));
		return actual.contains(expected);
	}

	/*
	 * public boolean compareMultipleText(List<String> excelArray, List<String>
	 * webElementArray, int... index) {
	 * 
	 * int count = 0;
	 * 
	 * if (index.length == 0) { index[0] = 0; count = webElementArray.size(); }
	 * else if (index.length == 1 && index[0] < webElementArray.size()) { count
	 * = webElementArray.size(); } else if (index.length == 2 && index[1] <
	 * webElementArray.size() && index[0] < index[1]) { count = index[1]; }
	 * 
	 * log.info(Utilities.getCurrentThreadId() + "Size of the Excel Array List="
	 * + excelArray.size()); log.info(Utilities.getCurrentThreadId() +
	 * "Size of the Web Element Array List=" + webElementArray.size()); for (int
	 * i = index[0]; i < count; i++) { log.info(Utilities.getCurrentThreadId() +
	 * "Comparing value no:" + i); if
	 * (excelArray.get(i).equals(webElementArray.get(i))) {
	 * log.info(Utilities.getCurrentThreadId() + "Value from Test Data sheet " +
	 * excelArray.get(i)); log.info(Utilities.getCurrentThreadId() +
	 * "Value from the application " + webElementArray.get(i));
	 * log.info(Utilities.getCurrentThreadId() + "Both the values are equal.");
	 * } else { log.info(Utilities.getCurrentThreadId() +
	 * "Value from Test Data sheet " + excelArray.get(i));
	 * log.info(Utilities.getCurrentThreadId() + "Value from the application " +
	 * webElementArray.get(i)); log.info(Utilities.getCurrentThreadId() +
	 * "Values are not equal. Returning False"); return false; } } return true;
	 * }
	 */
}
