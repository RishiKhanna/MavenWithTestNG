package com.generic.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import com.generic.exceptions.WaitException;
import com.generic.utilities.Utilities;

public class MobileActions extends WebActions implements IMobileAction {

    private AppiumDriver driver;

    public MobileActions(WebDriver driver) {
        super(driver);
        this.driver = (AppiumDriver) super.driver;
    }

    public void tap(String syncKey, By locator) throws TimeoutException, WaitException {
        TouchAction action = new TouchAction(driver);
        action.tap(wait.syncElementUsing(syncKey, driver, locator)).perform();
        LOGGER.info(Utilities.getCurrentThreadId() + "Tapped on element with locator:" + locator);
    }

    public void swipeOnScreen(int xstart, int ystart, int xend, int yend, int duration) {
        driver.swipe(xstart, ystart, xend, yend, duration);
    }

    public void setOrientationTo(String orientation) {
        if ("Landscape".equals(orientation)) {
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    public void closeApp() {
        driver.closeApp();
    }
}
