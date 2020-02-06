package ru.job4j.vkfriendskt.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */
class GetFriendsResponse {
    @SerializedName("response")
    @Expose
    var response: Response? = null

    inner class Response {
        @SerializedName("count")
        @Expose
        var count: Int? = null
        @SerializedName("items")
        @Expose
        var fiends: List<Friend>? = null

        inner class Friend {
            @SerializedName("id")
            @Expose
            var id = 0
            @SerializedName("first_name")
            @Expose
            var firstName: String? = null
            @SerializedName("last_name")
            @Expose
            var lastName: String? = null
            @SerializedName("is_closed")
            @Expose
            var isClosed: Boolean? = null
            @SerializedName("can_access_closed")
            @Expose
            var canAccessClosed: Boolean? = null
            @SerializedName("photo_100")
            @Expose
            var photo100: String? = null
            @SerializedName("online")
            @Expose
            var online: Int? = null
            @SerializedName("track_code")
            @Expose
            var trackCode: String? = null

        }
    }
}