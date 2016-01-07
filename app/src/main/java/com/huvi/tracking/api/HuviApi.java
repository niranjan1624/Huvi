package com.huvi.tracking.api;

import com.huvi.tracking.BuildConfig;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Created by Niranjan on 1/7/2016.
 */
public class HuviApi {

    private static final String SERVER_URL = "";
    private static HuviApi sInstance;
    private HuviService mService;
    private static final String PLACES_URL = "https://maps.googleapis.com/maps/api";

    /**
     * Singleton "constructor"
     *
     * @return Returns the singleton sInstance
     */
    public static HuviService getService() {
        if (sInstance == null) {
            sInstance = new HuviApi();
        }

        return sInstance.mService;
    }

    /**
     * Private constructor
     */
    private HuviApi() {
        // configuring testing if testing
        // TODO: Need to handle this properly
        //SERVER_URL = "https://server.easycommute.co/sts";
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setRequestInterceptor(requestInterceptor)
                .setEndpoint(SERVER_URL);

        // add full request/response logs if we are a debug build
        if (BuildConfig.DEBUG) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL).setLog(
                    new AndroidLog("RetrofitApi"));
        }

        mService = builder.build().create(HuviService.class);
    }

    public static HuviService getGoogleApiService() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(PLACES_URL);

        return builder.build().create(HuviService.class);
    }

    /**
     * A request interceptor used to modify all requests sent through this service. Currently,
     * this is responsible for adding a User-Agent and X-Authorization header to  the request.
     */
    private RequestInterceptor requestInterceptor = new RequestInterceptor() {

        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept", "application/json");
        }
    };


}
