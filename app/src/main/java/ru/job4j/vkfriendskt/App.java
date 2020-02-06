package ru.job4j.vkfriendskt;

import android.app.Application;

import ru.job4j.vkfriendskt.di.AppComponent;
import ru.job4j.vkfriendskt.di.DaggerAppComponent;
import ru.job4j.vkfriendskt.di.NetworkServiceModule;

public class App extends Application {
    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();

    }

    public static AppComponent getComponent() {
        return appComponent;
    }

}
