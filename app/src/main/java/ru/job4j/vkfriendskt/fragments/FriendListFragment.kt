package ru.job4j.vkfriendskt.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.activities.AuthActivity
import ru.job4j.vkfriendskt.activities.FriendsListActivity
import ru.job4j.vkfriendskt.activities.UserDetailsActivity
import ru.job4j.vkfriendskt.adapters.FriendsListAdapter
import ru.job4j.vkfriendskt.model.GetFriendsResponse
import ru.job4j.vkfriendskt.viewmodels.FriendsListViewModel

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class FriendListFragment : Fragment() {
    val TAG = "MainActivity"
    val FIELDS = "photo_100"
    private var vkUsersMutableLiveData = MutableLiveData<GetFriendsResponse>()
    var token: String = ""
    var userId: Int = 0
    lateinit var friendsListAdapter: FriendsListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var viewModel: FriendsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_user_list, container, false)
        viewModel = ViewModelProvider(this)[FriendsListViewModel::class.java]
        var observer = MyObserver()
        viewModel.getvkUsersMutableLiveData().observe(viewLifecycleOwner, observer)
        arguments.let {
            token = arguments?.getString(FriendsListActivity.TOKEN).toString()
            userId = arguments?.getInt(FriendsListActivity.USER_ID, 0)!!
        }
        var params: HashMap<String, String> = HashMap()
        params.put("order", "name")
        params.put("fields", "photo_100")
        params.put("count", "10")
        viewModel.update(token, userId, "5.103", params)
        setupAdapter(view)
        return view
    }


    fun setupAdapter(view: View) {
        recyclerView = view.findViewById(R.id.recyclerFriendsList) as RecyclerView
        linearLayoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = linearLayoutManager
        friendsListAdapter = FriendsListAdapter(object : FriendsListAdapter.Callback {
            override fun onItemClicked(item: GetFriendsResponse.Response.Friend) {
                Toast.makeText(
                    view.context,
                    item.firstName + " " + item.lastName,
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(context, UserDetailsActivity::class.java)
                intent.putExtra(AuthActivity.TOKEN,token)
                intent.putExtra(AuthActivity.USER_ID,item.id)
                startActivity(intent)



            }
        })
        recyclerView.adapter = friendsListAdapter
    }

    inner class MyObserver : Observer<GetFriendsResponse> {
        override fun onChanged(getFriendsResponse: GetFriendsResponse) {
            val friendsList = getFriendsResponse.response?.fiends
            friendsListAdapter.setData(friendsList!!)
        }
    }

    companion object {
        fun of(token: String, userId: Int): FriendListFragment {
            val friendListFragment =
                FriendListFragment()
            val bundle = Bundle()
            bundle.putString(AuthActivity.TOKEN, token)
            bundle.putInt(AuthActivity.USER_ID, userId)
            friendListFragment.arguments = bundle
            return friendListFragment
        }
    }
}