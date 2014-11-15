package com.generic.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.generic.exceptions.WaitException;

class WebDecorator implements IWebAction {

    protected IWebAction action;

    WebDecorator(IWebAction action) {
        this.action = action;
    }

    public String getText(String syncKey, By locator) throws TimeoutException, WaitException {
        return action.getText(syncKey, locator);
    }

    public void click(String syncKey, By element) throws TimeoutException, WaitException {
        action.click(syncKey, element);
    }
}
