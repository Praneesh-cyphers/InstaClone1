package com.example.instaclone1;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Zv5Z3RUXovm8RY0J7eDf2XneEmtP1b1Rj5uQXYAS")
                .clientKey("RxYORo4fMU6KgJII6jrbCYa5uhrYhBoph52sHJIg")
                .server("https://parseapi.back4app.com/")
                .build());

    }
}
