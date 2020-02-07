package ru.job4j.vkfriendskt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user_details.*
import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.activities.AuthActivity

import ru.job4j.vkfriendskt.viewmodels.UserDetailsViewModel

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class UserDetailsFragment : Fragment() {
    //private lateinit var binding: FragmentUserDetailsBinding
    private lateinit var viewModel: UserDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  binding = FragmentUserDetailsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[UserDetailsViewModel::class.java]
        viewModel.getUserInfoResponse().observe(viewLifecycleOwner, Observer {
            val user = it.response?.get(0)
            if (user != null) {

                user.firstName?.let { tVUserFirstName.append(user.firstName)}
                user.lastName?.let { tVUserLastName.append(user.lastName)}
                user.about?.let { tVUserAbout.append("${user.about}") }
                user.bdate?.let { tVUserBdate.append(user.bdate)}
                user.city?.title?.let { tVUserCity.append(user.city?.title)}
                user.mobilePhone?.let { tVUserContacts.append(user.mobilePhone)}
                user.country?.title?.let { tVUserCountry.append(user.country?.title)}
                user.educationStatus?.let { tVUserEducation.append(user.educationStatus) }

                user.followersCount?.let { tVUserFollowers_count.append("\n${user.followersCount}")}
                user.interests?.let { tVUserInterests.append(user.interests)}
                tVUserOnline.setText(if (user.online == 1) "online" else "offline")
                tVUserStatus.append(user.status)
                user.schools?.let { tVUserSchools.append(user.schools.toString()) }
                user.universities?.let { tVUserUniversities.append(user.universities.toString()) }
                Picasso.with(context).load(user.photo400Orig)
                    .into(iVUserPhoto_200)
            }
        })
        val token = arguments?.let { arguments?.getString(AuthActivity.TOKEN).toString() }
        val userId = arguments?.getInt(AuthActivity.USER_ID, 0)
        val params: HashMap<String, String> = HashMap()
        params.put("order", "name")
        params.put(
            "fields",
            " sex, bdate, city, country, photo_400_orig, online, contacts, education, universities, schools, status, last_seen, followers_count," +
                    "interests, about"
        )
        viewModel.update(token!!, userId!!, "5.103", params)
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    companion object {
        fun of(token: String, userId: Int): UserDetailsFragment =
            UserDetailsFragment().apply {
                arguments = bundleOf(
                    AuthActivity.TOKEN to token,
                    AuthActivity.USER_ID to userId
                )
            }
    }
}