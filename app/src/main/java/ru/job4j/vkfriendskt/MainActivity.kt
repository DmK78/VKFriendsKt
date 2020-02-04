package ru.job4j.vkfriendskt

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Response
import ru.job4j.vkfriendskt.model.VKUsers
import ru.job4j.vkfriendskt.network.NetworkService
import ru.job4j.vkfriendskt.network.VK_api
import retrofit2.Callback as Callback1


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    private lateinit var viewModel: MainViewModel
    val FIELDS = "photo_100"
    private lateinit var networkService: NetworkService
    private var vkUsersMutableLiveData = MutableLiveData<VKUsers>()
    lateinit var texView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texView = findViewById(R.id.text)
        var observer = MyObserver()
        vkUsersMutableLiveData.observe(this, observer)
        VK.initialize(applicationContext)
        VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization

                println(token.userId.toString())



                token.userId?.let {
                    VK_api.getService().getUsers(token.accessToken, token.userId!!,"5.103", "fields=photo_100")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : DisposableSingleObserver<VKUsers?>() {
                            override fun onSuccess(vkUsers: VKUsers) {
                                vkUsersMutableLiveData.postValue(vkUsers)
                                texView.setText(vkUsers.response.items.get(0).firstName)
                            }

                            override fun onError(e: Throwable) {
                                Log.i("MyError", e?.message)
                            }
                        })


                }




            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun show(s: String) {
        texView.setText(s)

    }

    inner class MyObserver : Observer<VKUsers> {
        override fun onChanged(t: VKUsers?) {

            if (t != null) {
                texView.setText(t.response.items.get(0).firstName)

            }

        }
    }


}
