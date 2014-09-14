package com.generic.page.base;

import org.openqa.selenium.WebDriver;
import com.generic.actions.MobileActions;
import com.generic.exceptions.WaitException;

public class MobilePageBase extends PageBase{

	protected WebDriver driver;
	protected MobileActions action;

	public MobilePageBase(WebDriver driver) throws WaitException {
		this.driver = driver;
		this.action = new MobileActions(driver);
	}
}
