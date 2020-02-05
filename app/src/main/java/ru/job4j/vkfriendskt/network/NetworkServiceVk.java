package ru.job4j.vkfriendskt.network;

import androidx.lifecycle.MutableLiveData;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.job4j.vkfriendskt.model.GetFriendsResponse;
import ru.job4j.vkfriendskt.model.GetUserResponse;

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

public class NetworkServiceVk {

    private Retrofit mRetrofit;
    private static String BASE_URL = "https://api.vk.com/method/";
    private static VkApiInterface service;

    public NetworkServiceVk() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        mRetrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getFriends(String token, int user_id, final String v, Map<String, String> params, final MutableLiveData<GetFriendsResponse> callback) {
        getJSONApi().getUserFriends(token, user_id,v,params )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<GetFriendsResponse>() {
                    @Override
                    public void onSuccess(GetFriendsResponse getFriendsResponse) {
                        callback.postValue(getFriendsResponse);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });


    }

    public void getUser (String token, int user_id, final String v, Map<String, String> params, final MutableLiveData<GetUserResponse> callback) {
        getJSONApi().getUser(token, user_id,v,params )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<GetUserResponse>() {
                    @Override
                    public void onSuccess(GetUserResponse response) {
                        callback.postValue(response);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });


    }


    public VkApiInterface getJSONApi() {
        return mRetrofit.create(VkApiInterface.class);
    }

}

