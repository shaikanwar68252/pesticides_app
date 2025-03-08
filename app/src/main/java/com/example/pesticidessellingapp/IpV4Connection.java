package com.example.pesticidessellingapp;

import android.content.Context;
import android.content.SharedPreferences;

import java.net.URI;

public class IpV4Connection {

    private static final String PREF_NAME = "MyPrefs";

    private static final String CONNECTOIN_ID_KEY = "connectionId";

    private static String baseUrl = "https://172.25.85.117/Pesticides/";

    private static String getBaseUrl() {
        return baseUrl;
    }

    public static String connectionId;

    public static String getConnectoinIdKey(Context context) {

        if (connectionId == null) {
            SharedPreferences prefs = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE);
            connectionId = prefs.getString(CONNECTOIN_ID_KEY,null);
        }
        return connectionId;
    }




}
