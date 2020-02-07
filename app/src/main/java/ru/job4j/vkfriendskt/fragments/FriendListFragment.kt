package ru.job4j.vkfriendskt.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.activities.AuthActivity

import ru.job4j.vkfriendskt.activities.UserDetailsActivity
import ru.job4j.vkfriendskt.model.user.VkUser
import ru.job4j.vkfriendskt.viewmodels.FriendsListViewModel
import ru.job4j.vkfriendskt.adapters.FriendsListAdapter as FriendsListAdapter1

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class FriendListFragment : Fragment() {
    var token: String = ""
    var userId: Int = 0
    private lateinit var friendsListAdapter: FriendsListAdapter1
    private lateinit var viewModel: FriendsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_user_list, container, false)
        viewModel = ViewModelProvider(this)[FriendsListViewModel::class.java]
        setupAdapter(view)
        viewModel.getvkUsersMutableLiveData().observe(viewLifecycleOwner, Observer {
            val friendsList = it.response?.users

            friendsListAdapter.setData(friendsList!!)
        })
        arguments?.let {
            token = arguments?.getString(AuthActivity.TOKEN).toString()
            userId = arguments?.getInt(AuthActivity.USER_ID, 0)!!
        }
        var params: HashMap<String, String> = HashMap()
        params.put("order", "name")
        params.put("fields", "photo_100")
        params.put("count", "50")
        viewModel.update(token, userId, "5.103", params)
        return view
    }

    fun setupAdapter(view: View) {
        val recyclerView = view.findViewById(R.id.recyclerFriendsList) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        friendsListAdapter = FriendsListAdapter1(object : FriendsListAdapter1.Callback {
            override fun onItemClicked(item: VkUser) {
                startActivity(UserDetailsActivity.create(view.context, token, item.id))
            }
        })
        recyclerView.adapter = friendsListAdapter
    }

    companion object {
        fun of(token: String, userId: Int): FriendListFragment =
            FriendListFragment().apply {
                arguments = bundleOf(
                    AuthActivity.TOKEN to token,
                    AuthActivity.USER_ID to userId
                )
            }
    }
}