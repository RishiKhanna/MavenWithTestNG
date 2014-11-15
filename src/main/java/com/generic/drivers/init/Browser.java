package com.generic.drivers.init;

import org.openqa.selenium.Platform;

public class Browser {
    private String name;
    private String version;
    private Platform platform;

    public Browser(String name, String version, Platform platform) {
        this.name = name;
        this.version = version;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Platform getPlatform() {
        return platform;
    }
}
