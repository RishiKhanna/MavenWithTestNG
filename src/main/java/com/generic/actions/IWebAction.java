package com.generic.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.generic.exceptions.WaitException;

public interface IWebAction {

    public String getText(String syncKey, By locator) throws TimeoutException, WaitException;

    public void click(String syncKey, By element) throws TimeoutException, WaitException;
}
