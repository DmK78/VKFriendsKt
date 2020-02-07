package ru.job4j.vkfriendskt.network

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.job4j.vkfriendskt.model.GetFriends
import ru.job4j.vkfriendskt.model.GetUser

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */
class NetworkService {
    private val mRetrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client =
            OkHttpClient.Builder().addInterceptor(interceptor).build()
        mRetrofit = Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFriends(
        token: String,
        user_id: Int,
        v: String,
        params: Map<String, String>,
        callback: MutableLiveData<GetFriends>
    ) {
        jSONApi.getUserFriends(token, user_id, v, params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<GetFriends?>() {
                override fun onSuccess(getFriendsResponse: GetFriends) {
                    callback.postValue(getFriendsResponse)
                }

                override fun onError(e: Throwable) {}
            })
    }

    fun getUser(
        token: String,
        user_id: Int,
        v: String,
        params: Map<String, String>,
        callback: MutableLiveData<GetUser>
    ) {
        jSONApi.getUser(token, user_id, v, params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<GetUser?>() {
                override fun onSuccess(response: GetUser) {
                    callback.postValue(response)
                }

                override fun onError(e: Throwable) {}
            })
    }

    private val jSONApi: JSonHolderApi
        get() = mRetrofit.create(JSonHolderApi::class.java)

    companion object {
        private const val BASE_URL = "https://api.vk.com/method/"
    }


}