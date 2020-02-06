package ru.job4j.vkfriendskt

import android.app.Application
import ru.job4j.vkfriendskt.di.AppComponent
import ru.job4j.vkfriendskt.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    companion object {
        var component: AppComponent? = null
            private set
    }
}