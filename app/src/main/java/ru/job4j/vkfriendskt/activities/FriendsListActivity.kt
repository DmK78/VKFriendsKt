package ru.job4j.vkfriendskt.activities

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import ru.job4j.vkfriendskt.fragments.FriendListFragment

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */


class FriendsListActivity : BaseActivity() {

    override fun loadFrg(): Fragment {
        return FriendListFragment.of(
            intent.getStringExtra(AuthActivity.TOKEN),
            intent.getIntExtra(AuthActivity.USER_ID, 0)
        )
    }
    companion object {
        fun create(context: Context, token: String, userId: Int?): Intent {
            val intent = Intent(context, FriendsListActivity::class.java)
            intent.putExtra(AuthActivity.TOKEN,token)
            intent.putExtra(AuthActivity.USER_ID,userId)
            return intent
        }
    }

}
