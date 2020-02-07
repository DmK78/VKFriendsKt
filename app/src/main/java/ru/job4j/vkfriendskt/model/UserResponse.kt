package ru.job4j.vkfriendskt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.job4j.vkfriendskt.model.user.VkUser

data class UserResponse (
    @SerializedName("items")
    @Expose
    var users: List<VkUser>? = null
)