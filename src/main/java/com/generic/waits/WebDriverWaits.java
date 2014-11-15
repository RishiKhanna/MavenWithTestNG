package com.generic.waits;

import java.util.Collections;
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

    private static final Logger LOGGER = Logg.createLogger();
    private Utilities util = new Utilities();
    private static final Properties FRAMEWORKPROPERTIES = PropertyManager
            .loadFrameworkPropertyFile("framework.properties");
    private static final String ELEMENTSEARCHTIMEOUT = "elementSearchTimeOut";

    private WebElement waitForElementVisibility(WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        try {
            WebElement element = null;
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Waiting for the visibility of the element using By class:" + locator);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty(ELEMENTSEARCHTIMEOUT)));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "WebElement Present and Visible. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(
                    Utilities.getCurrentThreadId()
                            + "Time Out Exception while waiting for the visibility of the element using By class:"
                            + locator + "\n", tm);
        }
    }

    private WebElement waitForElementPresence(WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        try {
            WebElement element = null;
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Waiting for the presence of the element using By class:" + locator);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty("elementSearchTimeOut")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "WebElement Present. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(
                    Utilities.getCurrentThreadId()
                            + "Time Out Exception while waiting for the presence of the element using By class:"
                            + locator + "\n", tm);
        }
    }

    public WebElement waitForElementVisibility(WebDriver driver, WebElement beforeVisibilityElement)
            throws TimeoutException, WaitException {
        try {
            WebElement afterVisibilityElement = null;
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Waiting for the visibility of the web element:" + beforeVisibilityElement);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty(ELEMENTSEARCHTIMEOUT)));
            afterVisibilityElement = wait.until(ExpectedConditions
                    .visibilityOf(beforeVisibilityElement));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "WebElement Visible. Proceeding further...");
            return afterVisibilityElement;
        } catch (TimeoutException tm) {
            throw new TimeoutException(Utilities.getCurrentThreadId()
                    + "Time Out Exception while waiting for the visibility of the web element:"
                    + beforeVisibilityElement + "\n", tm);
        }
    }

    private WebElement waitForElementClickability(WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        try {
            WebElement element = null;
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Waiting for the clickability of the element:" + locator);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty(ELEMENTSEARCHTIMEOUT)));
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "WebElement Clickable. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(Utilities.getCurrentThreadId()
                    + "Time Out Exception while waiting for the clickability of the element:"
                    + locator + "\n", tm);
        }
    }

    private List<WebElement> waitForElementsVisibility(WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        try {
            List<WebElement> element = null;
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Waiting for the visibility of the elements:" + locator);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty(ELEMENTSEARCHTIMEOUT)));
            element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "WebElements Visible. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(Utilities.getCurrentThreadId()
                    + "Time Out Exception while waiting for the visibility of the elements:"
                    + locator + "\n", tm);
        }
    }

    private List<WebElement> waitForElementsPresence(WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        try {
            List<WebElement> element = null;
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Waiting for the presence of the elements:" + locator);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty(ELEMENTSEARCHTIMEOUT)));
            element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "WebElements Present. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(Utilities.getCurrentThreadId()
                    + "Time Out Exception while waiting for the presence of the elements:"
                    + locator + "\n", tm);
        }
    }

    public void waitForTimePeriod(int timeOut) throws WaitException, InterruptedException {
        try {
            LOGGER.info(Utilities.getCurrentThreadId() + "Thread.sleep activated for " + timeOut
                    / 1000 + " seconds");
            Thread.sleep(timeOut);
            LOGGER.info(Utilities.getCurrentThreadId() + "Ended after waiting for " + timeOut
                    / 1000 + " seconds");
        } catch (InterruptedException ie) {
            throw new InterruptedException(
                    "Thread Interrupted Exception in the waitForTimePeriod() method of WebDriverWaits class");
        }
    }

    public Boolean checkForElementVisibility(WebDriver driver, final By locator)
            throws WaitException {
        try {
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Checking for the visibility of the element using By class:" + locator);
            WebDriverWait wait = new WebDriverWait(driver,
                    util.convertToInteger(FRAMEWORKPROPERTIES.getProperty(ELEMENTSEARCHTIMEOUT)));
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return driver.findElement(locator).isDisplayed();
                }
            });
            LOGGER.info(Utilities.getCurrentThreadId() + "Element visible.");
            return true;
        } catch (TimeoutException tm) {
            LOGGER.error(
                    Utilities.getCurrentThreadId()
                            + "Time Out Exception while waiting for the visibility of the element using By class:"
                            + locator + "\n", tm);
            return false;
        }
    }

    public WebElement syncElementUsing(String syncKey, WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        if ("visibility".equals(syncKey)) {
            return waitForElementVisibility(driver, locator);
        } else if ("clickability".equals(syncKey)) {
            return waitForElementClickability(driver, locator);

        } else if ("presence".equals(syncKey)) {
            return waitForElementPresence(driver, locator);
        } else {
            return null;
        }
    }

    public List<WebElement> syncElementsUsing(String syncKey, WebDriver driver, By locator)
            throws TimeoutException, WaitException {
        if ("visibility".equals(syncKey)) {
            return waitForElementsVisibility(driver, locator);
        } else if ("presence".equals(syncKey)) {
            return waitForElementsPresence(driver, locator);
        } else {
            return Collections.emptyList();
        }
    }
}
