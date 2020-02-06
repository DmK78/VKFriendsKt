package ru.job4j.vkfriendskt.di;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.job4j.vkfriendskt.network.NetworkService;

@Module
public class NetworkServiceModule {
    @Singleton
    @Provides
    public NetworkService providesNetworkService() {
        return new NetworkService();
    }
}
