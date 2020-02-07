package ru.job4j.vkfriendskt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.job4j.vkfriendskt.model.user.VkUser

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

data class GetUser(
    @SerializedName("response")
    @Expose
    var response: List<VkUser>? = null
)

