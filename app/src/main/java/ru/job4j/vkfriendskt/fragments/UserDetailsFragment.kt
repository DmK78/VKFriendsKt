package ru.job4j.vkfriendskt.fragments

import android.os.Bundle
import android.util.Log
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
import ru.job4j.vkfriendskt.adapters.FriendsListAdapter
import ru.job4j.vkfriendskt.model.GetFriendsResponse
import ru.job4j.vkfriendskt.model.GetUserResponse
import ru.job4j.vkfriendskt.viewmodels.FriendsListViewModel
import ru.job4j.vkfriendskt.viewmodels.UserDetailsViewModel

class UserDetailsFragment : Fragment() {


    private var vkUsersMutableLiveData = MutableLiveData<GetFriendsResponse>()
    var token: String = ""
    var userId: Int = 0



    private lateinit var viewModel: UserDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_user_list, container, false)
        viewModel = ViewModelProvider(this)[UserDetailsViewModel::class.java]
        var observer = MyObserver()
        viewModel.getUserInfoResponse().observe(viewLifecycleOwner, observer)
        arguments.let {
            token = arguments?.getString(FriendsListActivity.TOKEN).toString()
            userId = arguments?.getInt(FriendsListActivity.USER_ID, 0)!!
        }
        var params: HashMap<String, String> = HashMap()
        params.put("order", "name")
        params.put("fields", " sex, bdate, city, country, photo_200, online, contacts, education, universities, schools, status, last_seen, followers_count," +
                "interests about")

        viewModel.update(token, userId, "5.103", params)

        return view
    }

    inner class MyObserver : Observer<GetUserResponse> {
        override fun onChanged(item: GetUserResponse) {
            val user = item.response?.get(0)

            if (user != null) {
                Toast.makeText(
                    context,
                    "URRRRAAAAAAAAAAAAAA" + user.firstName + " "+ user.lastName,
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }



    companion object {
        fun of(token: String, userId: Int): UserDetailsFragment {
            val userDetailsFragment =
                UserDetailsFragment()
            val bundle = Bundle()
            bundle.putString(AuthActivity.TOKEN, token)
            bundle.putInt(AuthActivity.USER_ID, userId)
            userDetailsFragment.arguments = bundle
            return userDetailsFragment
        }
    }


}