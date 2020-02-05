package ru.job4j.vkfriendskt.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.job4j.vkfriendskt.model.GetFriendsResponse
import ru.job4j.vkfriendskt.model.GetUserResponse
import ru.job4j.vkfriendskt.network.NetworkServiceVk

class UserDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val userInfoResponse = MutableLiveData<GetUserResponse>()
    private var networkService: NetworkServiceVk = NetworkServiceVk()

    fun update(token: String, user_id: Int, v: String, params: Map<String, String>) {
        networkService.getUser(token, user_id, v, params, userInfoResponse)
    }

    fun getUserInfoResponse() = userInfoResponse














}