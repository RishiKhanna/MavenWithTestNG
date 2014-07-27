package org.testng.pages;

import org.testng.actions.BrowserActions;
import org.testng.actions.Verifications;
import org.testng.utilities.Utilities;

public class PageBase {

	protected static final String VISIBILITY = "visibility";
	protected static final String PRESENCE = "presence";
	protected static final String CLICKABILITY = "clickability";
	
	protected BrowserActions action = new BrowserActions();
	protected Utilities util = new Utilities();
	protected Verifications verify = new Verifications();
}
