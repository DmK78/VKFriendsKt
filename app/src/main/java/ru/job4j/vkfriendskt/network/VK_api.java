package ru.job4j.vkfriendskt.network;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.job4j.vkfriendskt.model.VKUsers;

public class VK_api {


    private static String BASE_URL = "https://api.vk.com/method/";
    private static VkApiInterface service;

    /*@GET("wall.get?domain=pro_misto&count=100&v=5.53")
    Observable<VKwall> getVkwall();*/

    private VK_api() {
    }

    public static VkApiInterface getService() {
        if (service == null) {
/*            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();*/
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(VkApiInterface.class);
            return service;
        } else {
            return service;
        }
    }

    /*public static void getUsers(String token , int userId, final MutableLiveData<VKUsers> callback) {

       getService().getUsers1(token, userId, "5.103", "fields=photo_100")
                .enqueue(new Callback<VKUsers>() {

                    @Override
                    public void onResponse(Call<VKUsers> call, Response<VKUsers> response) {
                        //Log.d(TAG, "onResponse response:: " + response);
                        if (response.body() != null) {
                            VKUsers result = response.body();

                            callback.postValue(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<VKUsers> call, Throwable t) {
                        callback.setValue(null);
                    }
                });
    }*/



}

