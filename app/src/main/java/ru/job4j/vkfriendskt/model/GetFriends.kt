package ru.job4j.vkfriendskt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */
data class GetFriends(
    @SerializedName("response")
    @Expose
    var response: UserResponse? = null
)