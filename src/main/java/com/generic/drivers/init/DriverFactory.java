package com.generic.drivers.init;

public class DriverFactory {

    public IDriver getDriver(String driverType) {
        if (driverType == null) {
            return null;
        }
        if ("remote".equalsIgnoreCase(driverType)) {
            return new RemoteDriver();
        } else if ("local".equalsIgnoreCase(driverType)) {
            return new LocalDriver();
        } else if ("mobile".equalsIgnoreCase(driverType)) {
            return new MobileDriver();
        }
        return null;
    }

}
