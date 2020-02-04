package ru.job4j.vkfriendskt.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import ru.job4j.vkfriendskt.BuildConfig;
import ru.job4j.vkfriendskt.model.VKUsers;


/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 01.12.2019
 */
public class NetworkService {
    private Retrofit mRetrofit;
    public static final String BASE_URL = "https://api.vk.com/method/";
    public static final String FIELDS = "photo_100";


    public NetworkService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        client.addInterceptor(interceptor);
        OkHttpClient clientErrorIntercept = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        if (response.code() >= 400 && response.code() <= 599) {
                            Log.i("MyError", "" + response.code());
                            return response;
                        }
                        return response;
                    }
                })
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .client(clientErrorIntercept)
                .build();
    }


    /*public void getCurWeather(Place place, MutableLiveData<CurrentWeather> callback) {

        getJSONApi().getCurrentWeatherByCoord(place.getLatLng().latitude, place.getLatLng().longitude,
                Constants.key, Constants.units, Constants.lang)
                .enqueue(new Callback<CurrentWeather>() {

                    @Override
                    public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                        //Log.d(TAG, "onResponse response:: " + response);
                        if (response.body() != null) {
                            CurrentWeather result = response.body();
                            if (!TextUtils.isEmpty(place.getName())) {
                                result.setCityName(place.getName());
                            }
                            result.setLatLng(place.getLatLng());
                            callback.postValue(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> call, Throwable t) {
                        callback.setValue(null);
                    }
                });
    }*/


    public void getUsers(int userId, final MutableLiveData<VKUsers> callback) {

       /* getJSONApi().getUsers(userId, FIELDS, 10, "name")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<VKUsers>() {
                    @Override
                    public void onSuccess(VKUsers vkUsers) {
                        callback.postValue(vkUsers);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });*/
    }


    /*public void getFiveDaysWeatherRX (Place place, MutableLiveData<FiveDaysWeather> callback) {

        getJSONApi().getFiveDaysWeatherRX(place.getLatLng().latitude, place.getLatLng().longitude,
                Constants.key, Constants.units, Constants.lang)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<FiveDaysWeather>() {
                    @Override
                    public void onSuccess(FiveDaysWeather fiveDaysWeather) {
                        fiveDaysWeather.calculateDateTime();
                        callback.postValue(fiveDaysWeather);
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }*/


    public VkApiInterface getJSONApi() {
        return mRetrofit.create(VkApiInterface.class);
    }



}