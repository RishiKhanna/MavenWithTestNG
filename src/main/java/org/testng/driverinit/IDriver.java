package org.testng.driverinit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public abstract class IDriver {
	
	protected abstract void setPath();

	protected abstract WebDriver getdriver(Capabilities capabilities);

	protected abstract Capabilities getCapabilities(Browser browser);
	
	protected abstract WebDriver getRemoteDriver(String gridAddress,Capabilities capabilities);
	
}
