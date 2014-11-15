package com.generic.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.generic.exceptions.WaitException;
import com.generic.page.base.PageBase;

public class SyncWebWait extends WebDecorator {

    public SyncWebWait(IWebAction action) {
        super(action);
    }

    public String getText(String syncKey, By locator) throws TimeoutException, WaitException {
        new PageBase().doWait();
        return action.getText(syncKey, locator);
    }

    public void click(String syncKey, By element) throws TimeoutException, WaitException {
        action.click(syncKey, element);
        new PageBase().doWait();
    }
}
