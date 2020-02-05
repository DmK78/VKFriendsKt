package ru.job4j.vkfriendskt.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope

class AuthActivity : AppCompatActivity() {
    companion object {
        val TOKEN = "token"
        val USER_ID = "user_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VK.initialize(applicationContext)
        VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                val intent = Intent(applicationContext, FriendsListActivity::class.java)
                intent.putExtra(TOKEN,token.accessToken)
                intent.putExtra(USER_ID,token.userId as Int)
                startActivity(intent)
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