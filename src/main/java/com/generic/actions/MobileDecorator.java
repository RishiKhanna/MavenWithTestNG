package com.generic.actions;

abstract class MobileDecorator implements IMobileAction {

    protected IMobileAction action;

    MobileDecorator(IMobileAction action) {
        this.action = action;
    }
}
