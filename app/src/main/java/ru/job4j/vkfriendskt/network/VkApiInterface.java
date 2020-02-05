package ru.job4j.vkfriendskt.network;



import java.util.Map;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import retrofit2.http.QueryMap;
import ru.job4j.vkfriendskt.model.GetFriendsResponse;
import ru.job4j.vkfriendskt.model.GetUserResponse;

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 01.12.2019
 */

public interface VkApiInterface {

    @GET("friends.get?")
    Single<GetFriendsResponse> getUserFriends(
            @Query("access_token") String token,
            @Query("user_id") int userId,
            @Query("v") String v,
            @QueryMap Map<String, String> params
    );


    @GET("users.get?")
    Single<GetUserResponse> getUser(
            @Query("access_token") String token,
            @Query("user_id") int userId,
            @Query("v") String v,
            @QueryMap Map<String, String> params
    );




}
