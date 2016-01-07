package com.huvi.tracking.Utils;

import com.huvi.tracking.HuviApplication;
import com.huvi.tracking.model.DeliveryBoy;

/**
 * Created by Niranjan on 1/7/2016.
 */
public class HuviSingleton {
    private static HuviSingleton singleton = new HuviSingleton();

    private HuviSingleton() {
    }

    public static HuviSingleton getInstance() {
        return singleton;
    }

    public DeliveryBoy getDeliveryBoyDetails() {
        return HuviApplication.getsInstance().getDeliveryBoyDetails();
    }

    public void setDeliverBoy(DeliveryBoy deliverBoy) {
        if (deliverBoy != null ) {
            HuviApplication.getsInstance().setDeliveryBoyDetails(deliverBoy);
        }
    }
}
