package com.generic.drivers.init;

public class DriverFactory {

	public IDriver getDriver(String driverType) {
		if (driverType == null) {
			return null;
		}
		if (driverType.equalsIgnoreCase("remote")) {
			return new RemoteDriver();
		} else if (driverType.equalsIgnoreCase("local")) {
			return new LocalDriver();
		} else if (driverType.equalsIgnoreCase("mobile")) {
			return new MobileDriver();
		}
		return null;
	}

}
