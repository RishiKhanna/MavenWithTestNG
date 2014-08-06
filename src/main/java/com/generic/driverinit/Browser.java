package com.generic.driverinit;

import org.openqa.selenium.Platform;

public class Browser {
	public String name;
	public String version;
	private Platform platform;

	public Browser() {
		name = "chrome"; // |chrome|firefox|htmlunit|internet explorer|
		version = "";
		platform = Platform.WINDOWS;
	}

	public Browser(String name, String version, Platform platform) {
		this.name = name;
		this.version = version;
		this.platform = platform;
	}
}
