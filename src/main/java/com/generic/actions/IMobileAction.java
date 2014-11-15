package com.generic.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.generic.exceptions.WaitException;

public interface IMobileAction {
    public void tap(String syncKey, By locator) throws TimeoutException, WaitException;
}
