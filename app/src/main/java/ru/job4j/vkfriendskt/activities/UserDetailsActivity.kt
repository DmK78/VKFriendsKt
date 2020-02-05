package ru.job4j.vkfriendskt.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.fragments.FriendListFragment
import ru.job4j.vkfriendskt.fragments.UserDetailsFragment

class UserDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun loadFrg(): Fragment {
        return UserDetailsFragment.of(
            intent.getStringExtra(AuthActivity.TOKEN),
            intent.getIntExtra(AuthActivity.USER_ID, 0)
        )
    }

}