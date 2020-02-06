package ru.job4j.vkfriendskt.di;



import javax.inject.Singleton;

import dagger.Component;
import ru.job4j.vkfriendskt.viewmodels.FriendsListViewModel;
import ru.job4j.vkfriendskt.viewmodels.UserDetailsViewModel;

@Singleton
@Component(modules = {NetworkServiceModule.class})
public interface AppComponent {
    void injectTo(FriendsListViewModel friendsListViewModel);
    void injectTo(UserDetailsViewModel userDetailsViewModel);




}
