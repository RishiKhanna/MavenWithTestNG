package com.generic.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.generic.exceptions.WaitException;
import com.generic.utilities.Utilities;

public class MobileActions extends WebActions {

	private AppiumDriver driver;

	public MobileActions(WebDriver driver) {
		super(driver);
		this.driver = (AppiumDriver) super.driver;
	}

	public void tap(String syncKey, By locator) throws TimeoutException,
			WaitException {
		TouchAction action = new TouchAction(driver);
		action.tap(wait.syncElementUsing(syncKey, driver, locator)).perform();
		log.info(Utilities.getCurrentThreadId()
				+ "Tapped on element with locator:" + locator);
	}
}
