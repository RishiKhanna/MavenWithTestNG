package com.generic.waits;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.propertymgr.PropertyManager;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class WebDriverWaits {

	private Logger log = Logg.createLogger();
	private Utilities util = new Utilities();
	private final static Properties frameworkProperties = new PropertyManager()
			.loadPropertyFile("/src/main/resources/com/framework/properties/framework.properties");

	private WebElement waitForElementVisibility(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			WebElement element = null;
			log.info(Utilities.getCurrentThreadId()
					+ "Waiting for the visibility of the element using By class:"
					+ locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties
							.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(locator));
			log.info(Utilities.getCurrentThreadId()
					+ "WebElement Visible. Proceeding further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					Utilities.getCurrentThreadId()
							+ "Time Out Exception while waiting for the visibility of the element using By class:"
							+ locator + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public WebElement waitForElementVisibility(WebDriver driver,
			WebElement beforeVisibilityElement) throws TimeoutException {
		try {
			WebElement afterVisibilityElement = null;
			log.info(Utilities.getCurrentThreadId()
					+ "Waiting for the visibility of the web element:"
					+ beforeVisibilityElement);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties
							.getProperty("elementSearchTimeOut")));
			afterVisibilityElement = wait.until(ExpectedConditions
					.visibilityOf(beforeVisibilityElement));
			log.info(Utilities.getCurrentThreadId()
					+ "WebElement Visible. Proceeding further...");
			return afterVisibilityElement;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					Utilities.getCurrentThreadId()
							+ "Time Out Exception while waiting for the visibility of the web element:"
							+ beforeVisibilityElement + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private WebElement waitForElementClickability(WebDriver driver, By locator)
			throws TimeoutException {
		try {
			WebElement element = null;
			log.info(Utilities.getCurrentThreadId()
					+ "Waiting for the clickability of the element:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties
							.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions
					.elementToBeClickable(locator));
			log.info(Utilities.getCurrentThreadId()
					+ "WebElement Visible. Proceeding further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					Utilities.getCurrentThreadId()
							+ "Time Out Exception while waiting for the clickability of the element:"
							+ locator + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private List<WebElement> waitForElementsVisibility(WebDriver driver,
			By locator) throws TimeoutException {
		try {
			List<WebElement> element = null;
			log.info(Utilities.getCurrentThreadId()
					+ "Waiting for the visibility of the elements:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties
							.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(locator));
			log.info(Utilities.getCurrentThreadId()
					+ "WebElements Visible. Proceeding further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					Utilities.getCurrentThreadId()
							+ "Time Out Exception while waiting for the visibility of the elements:"
							+ locator + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private List<WebElement> waitForElementsPresence(WebDriver driver,
			By locator) throws TimeoutException {
		try {
			List<WebElement> element = null;
			log.info(Utilities.getCurrentThreadId()
					+ "Waiting for the presence of the elements:" + locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties
							.getProperty("elementSearchTimeOut")));
			element = wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(locator));
			log.info(Utilities.getCurrentThreadId()
					+ "WebElements Present. Proceeding further...");
			return element;
		} catch (TimeoutException tm) {
			throw new TimeoutException(
					Utilities.getCurrentThreadId()
							+ "Time Out Exception while waiting for the presence of the elements:"
							+ locator + "\n");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void waitForTimePeriod(int timeOut) {
		try {
			log.info(Utilities.getCurrentThreadId()
					+ "Thread.sleep activated for " + timeOut / 1000
					+ " seconds");
			Thread.sleep(timeOut);
			log.info(Utilities.getCurrentThreadId()
					+ "Ended after waiting for " + timeOut / 1000 + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public WebElement syncElementUsing(String syncKey, WebDriver driver,
			By locator) {
		if ("visibility".equals(syncKey))
			return waitForElementVisibility(driver, locator);
		else if ("clickability".equals(syncKey))
			return waitForElementClickability(driver, locator);
		else
			return null;
	}

	public List<WebElement> syncElementsUsing(String syncKey, WebDriver driver,
			By locator) {
		if ("visibility".equals(syncKey))
			return waitForElementsVisibility(driver, locator);
		else if ("presence".equals(syncKey))
			return waitForElementsPresence(driver, locator);
		else
			return null;
	}
}
