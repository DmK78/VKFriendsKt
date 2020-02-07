package ru.job4j.vkfriendskt.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.job4j.vkfriendskt.model.GetFriends
import ru.job4j.vkfriendskt.model.GetUser

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 01.12.2019
 */
interface JSonHolderApi {
    @GET("friends.get?")
    fun getUserFriends(
        @Query("access_token") token: String,
        @Query("user_id") userId: Int,
        @Query("v") v: String,
        @QueryMap params: Map<String, String>
    ): Single<GetFriends>

    @GET("users.get?")
    fun getUser(
        @Query("access_token") token: String,
        @Query("user_id") userId: Int,
        @Query("v") v: String,
        @QueryMap params: Map<String, String>
    ): Single<GetUser>
}