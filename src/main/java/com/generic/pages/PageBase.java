package com.generic.pages;

import org.openqa.selenium.WebDriver;

import com.generic.actions.BrowserActions;
import com.generic.actions.Comparator;
import com.generic.utilities.Utilities;

public class PageBase {

	protected static final String VISIBILITY = "visibility";
	protected static final String PRESENCE = "presence";
	protected static final String CLICKABILITY = "clickability";

	protected BrowserActions action;
	protected WebDriver driver;
	protected Utilities util = new Utilities();
	protected Comparator compare = new Comparator();

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.action = new BrowserActions(driver);
	}

	public PageBase navigateTo(String url) throws Exception {
		action.navigateToURL(url);
		return this;
	}

}
