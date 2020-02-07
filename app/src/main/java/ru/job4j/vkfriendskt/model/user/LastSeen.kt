package ru.job4j.vkfriendskt.model.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LastSeen (
    @SerializedName("time")
    @Expose
    var time: Int? = null,
    @SerializedName("platform")
    @Expose
    var platform: Int? = null
)