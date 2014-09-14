package com.generic.page.base;

import org.openqa.selenium.WebDriver;
import com.generic.actions.WebActions;
import com.generic.exceptions.WaitException;
import com.generic.web.pages.HomePage;

public class WebPageBase extends PageBase{

	protected WebDriver driver;
	protected WebActions action;
	
	public WebPageBase(WebDriver driver) throws WaitException {
		this.driver = driver;
		this.action = new WebActions(driver);
	}

	public HomePage navigateTo(String url) throws Exception {
		action.navigateToURL(url);
		return new HomePage(driver);
	}
}
