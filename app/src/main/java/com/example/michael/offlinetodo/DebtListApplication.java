package com.example.michael.offlinetodo;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class DebtListApplication extends Application {

    public static final String DEBT_GROUP_NAME = "ALL_DEBT";

    @Override
    public void onCreate() {
        super.onCreate();

        // add Debt subclass
        ParseObject.registerSubclass(Debt.class);

        // enable the Local Datastore
        Parse.enableLocalDatastore(getApplicationContext());

        // Required - Initialize the Parse SDK
        Parse.initialize(this);
        ParseUser.enableRevocableSessionInBackground();// TODO: 04/09/2015

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        // Prevents null - uses anonymous
        ParseUser.enableAutomaticUser();
        ParseUser.getCurrentUser().increment("RunCount");
        ParseUser.getCurrentUser().saveInBackground();

        ParseACL defaultACL = new ParseACL();// TODO: 04/09/2015
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
