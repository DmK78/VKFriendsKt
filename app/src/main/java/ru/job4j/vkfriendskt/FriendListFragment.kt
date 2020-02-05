package ru.job4j.vkfriendskt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_user_list.*
import ru.job4j.vkfriendskt.adapters.FriendsListAdapter
import ru.job4j.vkfriendskt.model.Friend
import ru.job4j.vkfriendskt.model.VKUsers
import ru.job4j.vkfriendskt.network.NetworkServiceVk

class FriendListFragment : Fragment() {
    val TAG = "MainActivity"
    private lateinit var viewModel: FriendsListViewModel
    val FIELDS = "photo_100"
    private var vkUsersMutableLiveData = MutableLiveData<VKUsers>()
    val adapter: FriendsListAdapter? = null
    var token: String = ""
    var userId: Int = 0
    private var recycler: RecyclerView? = null
    lateinit var friendsListAdapter: FriendsListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_user_list, container, false)
        arguments.let {
            token = arguments?.getString(MainActivity.TOKEN).toString()
            userId = arguments?.getInt(MainActivity.USER_ID, 0)!!
        }
        var observer = MyObserver()
        vkUsersMutableLiveData.observe(viewLifecycleOwner, observer)
        setupAdapter(view)


        var params: HashMap<String, String> = HashMap()
        params.put("order", "name")
        params.put("fields", "photo_100")
        params.put("count", "10")

        NetworkServiceVk.getService()
            .getUsers(token, userId!!, "5.103", params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<VKUsers?>() {
                override fun onSuccess(vkUsers: VKUsers) {
                    vkUsersMutableLiveData.postValue(vkUsers)
                }

                override fun onError(e: Throwable) {
                    Log.i("MyError", e?.message)
                }
            })

        return view
    }

    fun setupAdapter(view: View) {
        recyclerView = view.findViewById(R.id.recyclerFriendsList) as RecyclerView
        linearLayoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = linearLayoutManager
        friendsListAdapter = FriendsListAdapter(object : FriendsListAdapter.Callback {
            override fun onItemClicked(item: Friend) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        recyclerView.adapter = friendsListAdapter

    }

    inner class MyObserver : Observer<VKUsers> {
        override fun onChanged(t: VKUsers?) {
            if (t != null) {
                friendsListAdapter!!.setData(t.response.fiends)
                friendsListAdapter!!.notifyDataSetChanged()
            }
            /*if (t != null) {
                vkUsersMutableLiveData.value?.response?.fiends?.forEach {
                    Log.i("Users", it.firstName + " " + it.lastName)

                }

            }*/

        }
    }


}