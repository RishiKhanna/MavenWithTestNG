package com.generic.drivers.init;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    public WebDriver getDriver(Browser browser);
}
