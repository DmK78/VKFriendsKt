package ru.job4j.vkfriendskt.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.job4j.vkfriendskt.App
import ru.job4j.vkfriendskt.model.GetFriendsResponse
import ru.job4j.vkfriendskt.network.NetworkService
import javax.inject.Inject

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */
class FriendsListViewModel(application: Application) : AndroidViewModel(application) {
    private val vkUsersMutableLiveData = MutableLiveData<GetFriendsResponse>()
    @Inject
    lateinit var networkService: NetworkService
    init {
        App.getComponent().injectTo(this)
    }

    fun update(token: String, user_id: Int, v: String, params: Map<String, String>) {
        networkService.getFriends(token, user_id, v, params, vkUsersMutableLiveData)
    }

    fun getvkUsersMutableLiveData() = vkUsersMutableLiveData


}