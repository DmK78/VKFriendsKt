package ru.job4j.vkfriendskt

import android.app.Application
import ru.job4j.vkfriendskt.di.AppComponent
import ru.job4j.vkfriendskt.di.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        private var appComponent: AppComponent? = null

        fun getComponent(): AppComponent? = appComponent
    }
}