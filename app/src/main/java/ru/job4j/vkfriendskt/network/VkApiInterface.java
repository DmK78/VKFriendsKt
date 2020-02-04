package ru.job4j.vkfriendskt.network;



import androidx.lifecycle.LiveData;

import java.util.Set;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import ru.job4j.vkfriendskt.model.VKUsers;

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 01.12.2019
 */

public interface VkApiInterface {

    @GET("friends.get?")
    Single<VKUsers> getUsers(
            @Query("access_token") String token,
            @Query("user_id") int userId,
            @Query("v") String v,
            @Query("params") String s


    );

    @GET("friends.get?")
    Call<VKUsers> getUsers1(
            @Query("access_token") String token,
            @Query("user_id") int userId,
            @Query("v") String v,
            @Query("params") String s


    );



}
