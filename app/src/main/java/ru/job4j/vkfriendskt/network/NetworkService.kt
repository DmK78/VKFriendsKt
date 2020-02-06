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
import ru.job4j.vkfriendskt.model.GetFriendsResponse
import ru.job4j.vkfriendskt.model.GetUserResponse

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
        callback: MutableLiveData<GetFriendsResponse>
    ) {
        jSONApi.getUserFriends(token, user_id, v, params)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableSingleObserver<GetFriendsResponse?>() {
                override fun onSuccess(getFriendsResponse: GetFriendsResponse) {
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
        callback: MutableLiveData<GetUserResponse>
    ) {
        jSONApi.getUser(token, user_id, v, params)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableSingleObserver<GetUserResponse?>() {
                override fun onSuccess(response: GetUserResponse) {
                    callback.postValue(response)
                }

                override fun onError(e: Throwable) {}
            })
    }

    private val jSONApi: JSonHolderApi
        private get() = mRetrofit.create(JSonHolderApi::class.java)

    companion object {
        private const val BASE_URL = "https://api.vk.com/method/"
    }


}