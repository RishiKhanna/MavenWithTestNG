package com.generic.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.generic.exceptions.WaitException;
import com.generic.page.base.PageBase;

public class SyncMobileWait extends MobileDecorator {

    public SyncMobileWait(IMobileAction action) {
        super(action);
    }

    public void tap(String syncKey, By locator) throws TimeoutException, WaitException {
        new PageBase().doWait();
        action.tap(syncKey, locator);
    }
}
