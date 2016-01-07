package com.huvi.tracking.events;

import com.squareup.otto.Bus;

/**
 * Created by Niranjan on 1/7/2016.
 */

public final class BusProvider {
    private static final Bus BUS = new Bus();

    /**
     * @return Instance of the event bus {@link com.squareup.otto.Bus}
     */
    public static Bus getInstance() {
        return BUS;
    }

    /**
     * Default constructor. No instances.
     */
    private BusProvider() { }
}
