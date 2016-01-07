package com.huvi.tracking;

import android.app.Application;

import com.huvi.tracking.Utils.PreferenceManager;
import com.huvi.tracking.api.HuviApi;
import com.huvi.tracking.events.BusProvider;
import com.huvi.tracking.model.DeliveryBoy;

/**
 * Created by Niranjan on 1/7/2016.
 */
public class HuviApplication extends Application {
    private static HuviApplication sInstance;

    public static HuviApplication getsInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // listen for global events
        BusProvider.getInstance().register(this);

        // make sure our service gets instantiated when the applications starts,
        // because this is kind of an expensive operation...
        // NOTE: this will also register all of the events in BuzzoopApi with the event bus!
        HuviApi.getService();
    }

    public void setDeliveryBoyDetails(DeliveryBoy deliveryBoy) {
        new PreferenceManager(this).updateDeliveryBoyDetails(deliveryBoy);
    }

    public DeliveryBoy getDeliveryBoyDetails() {
        return new PreferenceManager(this).getCommuter();
    }
}
