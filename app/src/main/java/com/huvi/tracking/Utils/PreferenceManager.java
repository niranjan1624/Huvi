package com.huvi.tracking.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.huvi.tracking.model.DeliveryBoy;

/**
 * Created by Ram Prasad on 10/8/2015.
 */
public class PreferenceManager {
    SharedPreferences.Editor editor;
    SharedPreferences pref;
    Context mContext;

    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "HuviTracking";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    // DeliveryBoy Details

    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_NAME  = "name";
    private static final String KEY_ID    = "id";
    private static final String KEY_GENDER = "gender";

    public PreferenceManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void updateDeliveryBoyDetails(DeliveryBoy deliveryBoy) {
        /*editor.putString(KEY_PHONE, deliveryBoy.phone);
        editor.putString(KEY_EMAIL, deliveryBoy.email);

        editor.putInt(KEY_ID, deliveryBoy.commuterId);
        editor.putString(KEY_NAME, deliveryBoy.name);
        editor.putString(KEY_GENDER, deliveryBoy.gender);*/
        editor.commit();
    }

    public DeliveryBoy getCommuter() {
        DeliveryBoy deliveryBoy = new DeliveryBoy();
      /*  deliveryBoy.regId = pref.getString(AppConstants.REGISTRATION_ID, "");

        deliveryBoy.name  = pref.getString(KEY_NAME, "");
        deliveryBoy.commuterId = pref.getInt(KEY_ID, 0);

        deliveryBoy.phone = pref.getString(KEY_PHONE, "");
        deliveryBoy.email = pref.getString(KEY_EMAIL, "");
        deliveryBoy.gender = pref.getString(KEY_GENDER, "");*/
        return deliveryBoy;
    }



    public void setLoggedIn(boolean isLoggedIn) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

}
