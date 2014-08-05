package com.generic.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.generic.driverinit.Browser;
import com.generic.driverinit.Grid;
import com.generic.propertymgr.PropertyManager;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;
import com.generic.waits.WebDriverWaits;

public class BrowserActions {

	private WebDriver driver;
	private final Comparator compare;
	private final Logger log;
	private final Properties applicationProperty;
	private final WebDriverWaits wait;
	private static Cookie cookie;

	public BrowserActions(WebDriver driver) {
		this.driver = driver;
		compare = new Comparator();
		log = Logg.createLogger();
		wait = new WebDriverWaits();
		applicationProperty = new PropertyManager()
				.loadPropertyFile("/src/main/resources/com/test/properties/application.properties");
	}

	public void storeDataInCookie(String key, String value) {
		cookie = new Cookie(key, value);
		log.info(Utilities.getCurrentThreadId() + "Cookie description");
		log.info(Utilities.getCurrentThreadId() + "Key=" + key + " " + "Value="
				+ value);
		driver.manage().addCookie(cookie);
		log.info(Utilities.getCurrentThreadId()
				+ "Successfully added cookie named " + key
				+ " to the HTML page");
	}

	public String retrieveDataFromCookie(String key) {
		log.info(Utilities.getCurrentThreadId() + "Retrieving the value "
				+ driver.manage().getCookieNamed(key).getValue()
				+ " stored in the cookie");
		return driver.manage().getCookieNamed(key).getValue();
	}

	public void openURLonLocalBrowser(Browser browser) {
		try {
			log.info(Utilities.getCurrentThreadId()
					+ "Navigating to Application URL on Local Browser:"
					+ applicationProperty.getProperty("applicationURL"));
			driver.get(applicationProperty.getProperty("applicationURL"));
			driver.manage().window().maximize();
			log.info(Utilities.getCurrentThreadId()
					+ "Successfully navigated to Application URL on the Local Browser");
		} catch (Exception ex) {
			log.fatal(Utilities.getCurrentThreadId()
					+ "Error in navigating the URL on the Local Browser::"
					+ applicationProperty.getProperty("applicationURL"));
			ex.printStackTrace();
		}
	}

	public void openURLonRemoteBrowser(Grid grid, Browser browser) {
		try {
			log.info(Utilities.getCurrentThreadId()
					+ "Navigating to Application URL on Remote Browser:"
					+ applicationProperty.getProperty("applicationURL"));
			driver.get(applicationProperty.getProperty("applicationURL"));
			driver.manage().window().maximize();
			log.info(Utilities.getCurrentThreadId()
					+ "Successfully navigated to Application URL on the Remote Browser");
		} catch (Exception ex) {
			log.fatal(Utilities.getCurrentThreadId()
					+ "Error in navigating to URL on the Remote Browser:"
					+ applicationProperty.getProperty("applicationURL"));
			ex.printStackTrace();
		}
	}

	public void closeBrowser(ITestContext context) {
		log.info(Utilities.getCurrentThreadId() + "Closing the browser");
		context.getAttribute(context.getCurrentXmlTest().getName());
		log.info(Utilities.getCurrentThreadId()
				+ "Sucessfully closed the browser" + "\n");
	}

	public void enterText(String syncKey, By element, String value)
			throws TimeoutException {
		WebElement webElement = null;
		webElement = wait.syncElementUsing(syncKey, driver, element);
		log.info(Utilities.getCurrentThreadId()
				+ "Clearing the content of the text box");
		webElement.clear();
		log.info(Utilities.getCurrentThreadId() + "Contents cleared");
		webElement.sendKeys(value);
		log.info(Utilities.getCurrentThreadId() + "Entered text:" + value
				+ " in text box with locator:" + element);
	}

	public void click(String syncKey, By element) throws TimeoutException {
		wait.syncElementUsing(syncKey, driver, element).click();
		log.info(Utilities.getCurrentThreadId()
				+ "Clicked on element with locator:" + element);
	}

	public void contextClick(String syncKey, By element)
			throws TimeoutException {
		Actions action = new Actions(driver);
		action.contextClick(wait.syncElementUsing(syncKey, driver, element))
				.perform();
		log.info(Utilities.getCurrentThreadId()
				+ "Clicked on element with locator:" + element
				+ " using JQuery");
	}

	public void clickByJQuery(String element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("$('" + element + "').click()");
		log.info("Clicked on element with locator:" + element + " using JQuery");
	}

	public void submitForm(String syncKey, By element) throws TimeoutException {
		wait.syncElementUsing(syncKey, driver, element).submit();
		log.info(Utilities.getCurrentThreadId()
				+ "Clicked on form submit button:" + element);
	}

	public void switchToSecondaryWindow(String windowTitle) {
		wait.waitForTimePeriod(10000);
		log.info(Utilities.getCurrentThreadId()
				+ "Secondary window title for switching: " + windowTitle);
		Set<String> windows = driver.getWindowHandles();
		log.info(Utilities.getCurrentThreadId() + "Windows="
				+ windows.toString());
		for (String strWindows : windows) {
			if (driver.switchTo().window(strWindows).getTitle()
					.equals(windowTitle)) {
				log.info(Utilities.getCurrentThreadId()
						+ "Switched to the window with title: "
						+ driver.switchTo().window(strWindows).getTitle());
				driver.switchTo().window(strWindows).manage().window()
						.maximize();
				log.info(Utilities.getCurrentThreadId()
						+ "Maximized the window with title "
						+ driver.switchTo().window(strWindows).getTitle());
				break;
			}
		}
	}

	public void selectOption(String syncKey, By parentLocator, String value) {
		List<WebElement> element = wait.syncElementsUsing(syncKey, driver,
				parentLocator);
		log.info(Utilities.getCurrentThreadId()
				+ "Size of the elements in the list=" + element.size());
		log.info(Utilities.getCurrentThreadId() + "Elements="
				+ element.toString());
		for (int i = 0; i < element.size(); i++) {
			String temp = element.get(i).getText()
					.replace((char) 0x00a0, (char) 0x0020);
			if (compare.compareExactText(value, (temp.trim()))) {
				log.info(Utilities.getCurrentThreadId() + " "
						+ "Clicking on option " + value);
				element.get(i).click();
				log.info(Utilities.getCurrentThreadId()
						+ "Successfully Clicked on option " + temp);
				break;
			}
		}
	}

	public void selectFromDropDown(String syncKey, By element, String value) {
		Select select = new Select(wait.syncElementUsing(syncKey, driver,
				element));
		select.selectByVisibleText(value);
		log.info(Utilities.getCurrentThreadId() + "Selected:" + value
				+ " from drop-down with locator:" + element);
	}

	public String getText(String syncKey, By element) {
		String actual = wait.syncElementUsing(syncKey, driver, element)
				.getText();
		log.info(Utilities.getCurrentThreadId() + "Actual Value:" + actual);
		return actual;
	}

	public String getTitle() {
		log.info(Utilities.getCurrentThreadId() + "Title of the page:"
				+ driver.getTitle());
		return driver.getTitle();
	}

	public String getAttributeValue(String syncKey, By element, String attribute) {
		log.info(Utilities.getCurrentThreadId() + "Retrieving the attribute "
				+ attribute + " of element " + element);
		return wait.syncElementUsing(syncKey, driver, element).getAttribute(
				attribute);
	}

	public List<String> getWebElementsTextInList(String syncKey, By locator) {
		log.info(Utilities.getCurrentThreadId()
				+ "Coverting the locator into a List of String");
		List<WebElement> weblElementList = wait.syncElementsUsing(syncKey,
				driver, locator);
		log.info(Utilities.getCurrentThreadId() + "List of size="
				+ weblElementList.size() + " elements created");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < weblElementList.size(); i++) {
			list.add(weblElementList.get(i).getText());
		}
		return list;
	}
}
