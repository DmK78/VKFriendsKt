package ru.job4j.vkfriendskt.di

import dagger.Module
import dagger.Provides
import ru.job4j.vkfriendskt.network.NetworkService
import javax.inject.Singleton

@Module
class NetworkServiceModule {
    @Singleton
    @Provides
    fun providesNetworkService(): NetworkService {
        return NetworkService()
    }
}