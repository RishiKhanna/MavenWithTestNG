package com.generic.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.generic.comparator.Comparator;
import com.generic.exceptions.URLNavigationException;
import com.generic.exceptions.WaitException;
import com.generic.property.mgr.PropertyManager;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;
import com.generic.waits.WebDriverWaits;

public class WebActions implements IWebAction {

    protected WebDriver driver;
    protected final Comparator compare = new Comparator();
    protected static final Logger LOGGER = Logg.createLogger();
    protected final WebDriverWaits wait = new WebDriverWaits();
    private static Cookie cookie;
    private static final Properties APPLICATIONPROPERTY = PropertyManager
            .loadApplicationPropertyFile("application.properties");
    private static final String APPLICATIONURL = "applicationURL";

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    public void storeDataInCookie(String key, String value) {
        cookie = new Cookie(key, value);
        LOGGER.info(Utilities.getCurrentThreadId() + "Cookie description");
        LOGGER.info(Utilities.getCurrentThreadId() + "Key=" + key + " " + "Value=" + value);
        driver.manage().addCookie(cookie);
        LOGGER.info(Utilities.getCurrentThreadId() + "Successfully added cookie named " + key
                + " to the HTML page");
    }

    public String retrieveDataFromCookie(String key) {
        LOGGER.info(Utilities.getCurrentThreadId() + "Retrieving the value "
                + driver.manage().getCookieNamed(key).getValue() + " stored in the cookie");
        return driver.manage().getCookieNamed(key).getValue();
    }

    public void navigateToURL(String url) throws URLNavigationException {
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Navigating to Application URL on Local Browser:"
                    + APPLICATIONPROPERTY.getProperty(APPLICATIONURL));
            driver.get(APPLICATIONPROPERTY.getProperty(APPLICATIONURL));
            LOGGER.info(Utilities.getCurrentThreadId()
                    + "Successfully navigated to Application URL on the Local Browser");
    }

    public void closeBrowser(ITestContext context) {
        LOGGER.info(Utilities.getCurrentThreadId() + "Closing the browser");
        context.getAttribute(context.getCurrentXmlTest().getName());
        LOGGER.info(Utilities.getCurrentThreadId() + "Sucessfully closed the browser" + "\n");
    }

    public void enterText(String syncKey, By element, String value) throws TimeoutException,
            WaitException {
        WebElement webElement = null;
        webElement = wait.syncElementUsing(syncKey, driver, element);
        LOGGER.info(Utilities.getCurrentThreadId() + "Clearing the content of the text box");
        webElement.clear();
        LOGGER.info(Utilities.getCurrentThreadId() + "Contents cleared");
        webElement.sendKeys(value);
        LOGGER.info(Utilities.getCurrentThreadId() + "Entered text:" + value
                + " in text box with locator:" + element);
    }

    public void click(String syncKey, By element) throws TimeoutException, WaitException {
        wait.syncElementUsing(syncKey, driver, element).click();
        LOGGER.info(Utilities.getCurrentThreadId() + "Clicked on element with locator:" + element);
    }

    public void contextClick(String syncKey, By element) throws TimeoutException, WaitException {
        Actions action = new Actions(driver);
        action.contextClick(wait.syncElementUsing(syncKey, driver, element)).perform();
        LOGGER.info(Utilities.getCurrentThreadId()
                + "Context click performed on element with locator:" + element + " using JQuery");
    }

    public void clickByJQuery(String element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("$('" + element + "').click()");
        LOGGER.info("Clicked on element with locator:" + element + " using JQuery");
    }

    public void submitForm(String syncKey, By element) throws TimeoutException, WaitException {
        wait.syncElementUsing(syncKey, driver, element).submit();
        LOGGER.info(Utilities.getCurrentThreadId() + "Clicked on form submit button:" + element);
    }

    public void switchToSecondaryWindow(String windowTitle) throws WaitException,
            InterruptedException {
        wait.waitForTimePeriod(10000);
        LOGGER.info(Utilities.getCurrentThreadId() + "Secondary window title for switching: "
                + windowTitle);
        Set<String> windows = driver.getWindowHandles();
        LOGGER.info(Utilities.getCurrentThreadId() + "Windows=" + windows.toString());
        for (String strWindows : windows) {
            if (driver.switchTo().window(strWindows).getTitle().equals(windowTitle)) {
                LOGGER.info(Utilities.getCurrentThreadId() + "Switched to the window with title: "
                        + driver.switchTo().window(strWindows).getTitle());
                driver.switchTo().window(strWindows).manage().window().maximize();
                LOGGER.info(Utilities.getCurrentThreadId() + "Maximized the window with title "
                        + driver.switchTo().window(strWindows).getTitle());
                break;
            }
        }
    }

    public void selectOption(String syncKey, By parentLocator, String value)
            throws TimeoutException, WaitException {
        List<WebElement> element = wait.syncElementsUsing(syncKey, driver, parentLocator);
        LOGGER.info(Utilities.getCurrentThreadId() + "Size of the elements in the list="
                + element.size());
        LOGGER.info(Utilities.getCurrentThreadId() + "Elements=" + element.toString());
        for (int i = 0; i < element.size(); i++) {
            String temp = element.get(i).getText().replace((char) 0x00a0, (char) 0x0020);
            if (compare.compareExactText(value, temp.trim())) {
                LOGGER.info(Utilities.getCurrentThreadId() + " " + "Clicking on option " + value);
                element.get(i).click();
                LOGGER.info(Utilities.getCurrentThreadId() + "Successfully Clicked on option "
                        + temp);
                break;
            }
        }
    }

    public void selectFromDropDown(String syncKey, By element, String value)
            throws TimeoutException, WaitException {
        Select select = new Select(wait.syncElementUsing(syncKey, driver, element));
        select.selectByVisibleText(value);
        LOGGER.info(Utilities.getCurrentThreadId() + "Selected:" + value
                + " from drop-down with locator:" + element);
    }

    public String getText(String syncKey, By element) throws TimeoutException, WaitException {
        String actual = wait.syncElementUsing(syncKey, driver, element).getText();
        LOGGER.info(Utilities.getCurrentThreadId() + "Actual Value:" + actual);
        return actual;
    }

    public String getTitle() {
        LOGGER.info(Utilities.getCurrentThreadId() + "Title of the page:" + driver.getTitle());
        return driver.getTitle();
    }

    public String getAttributeValue(String syncKey, By element, String attribute)
            throws TimeoutException, WaitException {
        LOGGER.info(Utilities.getCurrentThreadId() + "Retrieving the attribute " + attribute
                + " of element " + element);
        return wait.syncElementUsing(syncKey, driver, element).getAttribute(attribute);
    }

    public List<String> getWebElementsTextInList(String syncKey, By locator)
            throws TimeoutException, WaitException {
        LOGGER.info(Utilities.getCurrentThreadId() + "Coverting the locator into a List of String");
        List<WebElement> weblElementList = wait.syncElementsUsing(syncKey, driver, locator);
        LOGGER.info(Utilities.getCurrentThreadId() + "List of size=" + weblElementList.size()
                + " elements created");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < weblElementList.size(); i++) {
            list.add(weblElementList.get(i).getText());
        }
        return list;
    }

    public Boolean getVisibiltyOfElementLocatedBy(By locator) throws WaitException {
        return wait.checkForElementVisibility(driver, locator);
    }

    public void pressModifierKey(Keys key) {
        Actions action = new Actions(driver);
        action.keyDown(key);
    }

    public void pressKeys(Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(key);
    }

    public void switchToFrame(String syncKey, By locator) throws TimeoutException, WaitException {
        driver.switchTo().frame(wait.syncElementUsing(syncKey, driver, locator));
        LOGGER.info("Switched to frame with locator:" + locator);
    }

}
