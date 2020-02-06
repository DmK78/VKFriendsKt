package ru.job4j.vkfriendskt.di

import dagger.Component
import ru.job4j.vkfriendskt.viewmodels.FriendsListViewModel
import ru.job4j.vkfriendskt.viewmodels.UserDetailsViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkServiceModule::class])
interface AppComponent {
    fun injectTo(friendsListViewModel: FriendsListViewModel?)
    fun injectTo(userDetailsViewModel: UserDetailsViewModel?)
}