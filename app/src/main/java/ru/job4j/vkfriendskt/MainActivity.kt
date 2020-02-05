package ru.job4j.vkfriendskt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope


class MainActivity : AppCompatActivity() {
    private var fm: FragmentManager? = null
    private var friendsListFragment: FriendListFragment = FriendListFragment()
    private val userInfoFragment: Fragment? = null

    companion object {
        val TOKEN = "token"
        val USER_ID = "user_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm = supportFragmentManager // получить FragmentManager
        VK.initialize(applicationContext)
        VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                val bundle = Bundle()
                bundle.putString(TOKEN, token.accessToken)
                bundle.putInt(USER_ID, token.userId!!)
                friendsListFragment.setArguments(bundle)
                fm?.beginTransaction()
                    ?.add(
                        R.id.fragment_container,
                        friendsListFragment
                    ) // добавить фрагмент в контейнер
                    ?.commit()
            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
