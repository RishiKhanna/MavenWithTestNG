package com.generic.driverinit;

public class DriverFactory {

	public IDriver getDriver(String driverType) {
		if (driverType == null) {
			return null;
		}
		if (driverType.equalsIgnoreCase("remote")) {
			return new RemoteDriver();
		} else if (driverType.equalsIgnoreCase("local")) {
			return new LocalDriver();
		}
		return null;
	}

}
