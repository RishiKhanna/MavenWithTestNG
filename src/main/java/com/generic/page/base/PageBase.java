package com.generic.page.base;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.log4j.Logger;

import com.generic.comparator.Comparator;
import com.generic.utilities.Logg;
import com.generic.utilities.Utilities;

public class PageBase {

    protected static final String VISIBILITY = "visibility";
    protected static final String PRESENCE = "presence";
    protected static final String CLICKABILITY = "clickability";
    protected static final Utilities UTIL = new Utilities();
    protected static final Comparator COMPARE = new Comparator();
    private static final Logger LOGGER = Logg.createLogger();

    private static CyclicBarrier barrier = new CyclicBarrier(2);

    public void doWait() {
        try {
            barrier.await();
        } catch (InterruptedException ie) {
            LOGGER.error("InterruptedException in the doWait() method of PageBase class ", ie);
        } catch (BrokenBarrierException bbe) {
            LOGGER.error("BrokenBarrierException in the doWait() method of PageBase class ", bbe);
        }
    }
}
