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

import com.generic.exceptions.WaitException;
import com.generic.property.mgr.PropertyManager;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;
import com.google.common.base.Function;

public class WebDriverWaits {

	private Logger log = Logg.createLogger();
	private Utilities util = new Utilities();
	private final static Properties frameworkProperties = PropertyManager
			.loadFrameworkPropertyFile("framework.properties");

	private WebElement waitForElementVisibility(WebDriver driver, By locator)
			throws TimeoutException, WaitException {
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
			throw new WaitException(
					"Wait Exception in the waitForElementVisibility method of WebDriverWaits class"
							+ ex);
		}
	}

	public WebElement waitForElementVisibility(WebDriver driver,
			WebElement beforeVisibilityElement) throws TimeoutException,
			WaitException {
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
			throw new WaitException(
					"Wait Exception in the waitForElementVisibility method of WebDriverWaits class"
							+ ex);
		}
	}

	private WebElement waitForElementClickability(WebDriver driver, By locator)
			throws TimeoutException, WaitException {
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
			throw new WaitException(
					"Wait Exception in the waitForElementClickability method of WebDriverWaits class"
							+ ex);
		}
	}

	private List<WebElement> waitForElementsVisibility(WebDriver driver,
			By locator) throws TimeoutException, WaitException {
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
			throw new WaitException(
					"Wait Exception in the waitForElementsVisibility method of WebDriverWaits class"
							+ ex);
		}
	}

	private List<WebElement> waitForElementsPresence(WebDriver driver,
			By locator) throws TimeoutException, WaitException {
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
			throw new WaitException(
					"Wait Exception in the waitForElementsPresence method of WebDriverWaits class"
							+ ex);
		}
	}

	public void waitForTimePeriod(int timeOut) throws WaitException,
			InterruptedException {
		try {
			log.info(Utilities.getCurrentThreadId()
					+ "Thread.sleep activated for " + timeOut / 1000
					+ " seconds");
			Thread.sleep(timeOut);
			log.info(Utilities.getCurrentThreadId()
					+ "Ended after waiting for " + timeOut / 1000 + " seconds");
		} catch (InterruptedException e) {
			throw new InterruptedException();
		} catch (Exception ex) {
			throw new WaitException(
					"Wait Exception in the waitForTimePeriod method of WebDriverWaits class"
							+ ex);
		}
	}

	public Boolean checkForElementVisibility(WebDriver driver, final By locator)
			throws WaitException {
		try {
			log.info(Utilities.getCurrentThreadId()
					+ "Checking for the visibility of the element using By class:"
					+ locator);
			WebDriverWait wait = new WebDriverWait(driver,
					util.convertToInteger(frameworkProperties
							.getProperty("elementSearchTimeOut")));
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return driver.findElement(locator).isDisplayed();
				}
			});
			log.info(Utilities.getCurrentThreadId() + "Element visible.");
			return true;
		} catch (TimeoutException tm) {
			log.error(Utilities.getCurrentThreadId()
					+ "Time Out Exception while waiting for the visibility of the element using By class:"
					+ locator + "\n");
			return false;
		} catch (Exception ex) {
			throw new WaitException(
					"Wait Exception in the checkForElementVisibility method of WebDriverWaits class"
							+ ex);
		}
	}

	public WebElement syncElementUsing(String syncKey, WebDriver driver,
			By locator) throws TimeoutException, WaitException {
		if ("visibility".equals(syncKey))
			return waitForElementVisibility(driver, locator);
		else if ("clickability".equals(syncKey))
			return waitForElementClickability(driver, locator);
		else
			return null;
	}

	public List<WebElement> syncElementsUsing(String syncKey, WebDriver driver,
			By locator) throws TimeoutException, WaitException {
		if ("visibility".equals(syncKey))
			return waitForElementsVisibility(driver, locator);
		else if ("presence".equals(syncKey))
			return waitForElementsPresence(driver, locator);
		else
			return null;
	}
}
