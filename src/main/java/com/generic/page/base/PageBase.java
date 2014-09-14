package com.generic.page.base;


import com.generic.actions.Comparator;
import com.generic.utilities.Utilities;

public class PageBase {

	protected static final String VISIBILITY = "visibility";
	protected static final String PRESENCE = "presence";
	protected static final String CLICKABILITY = "clickability";
	protected static final Utilities util = new Utilities();
	protected static final Comparator compare = new Comparator();

	protected boolean hasDataToProcess=false;

	public synchronized boolean hasDataToProcess() {
		return this.hasDataToProcess;
	}

	public synchronized void setHasDataToProcess(boolean hasData) {
		this.hasDataToProcess = hasData;
	}
}
