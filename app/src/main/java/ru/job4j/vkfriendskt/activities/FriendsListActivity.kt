package ru.job4j.vkfriendskt.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.fragments.FriendListFragment

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */


class FriendsListActivity : BaseActivity() {

    companion object {
        val TOKEN = "token"
        val USER_ID = "user_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun loadFrg(): Fragment {
        return FriendListFragment.of(
            intent.getStringExtra(AuthActivity.TOKEN),
            intent.getIntExtra(AuthActivity.USER_ID, 0)
        )
    }


}
