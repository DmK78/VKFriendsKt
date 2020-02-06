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
import ru.job4j.vkfriendskt.activities.AuthActivity
import ru.job4j.vkfriendskt.databinding.FragmentUserDetailsBinding
import ru.job4j.vkfriendskt.viewmodels.UserDetailsViewModel

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class UserDetailsFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailsBinding
    private lateinit var viewModel: UserDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[UserDetailsViewModel::class.java]
        viewModel.getUserInfoResponse().observe(viewLifecycleOwner, Observer {
            val user = it.response?.get(0)
            if (user != null) {
                binding.tVUserFirstName.append(user.firstName)
                binding.tVUserLastName.append(user.lastName)
                binding.tVUserAbout.setText(user.about)
                binding.tVUserBdate.setText(user.bdate)
                binding.tVUserCity.setText(user.city?.title)
                binding.tVUserContacts.setText(user.mobilePhone)
                binding.tVUserCountry.setText(user.country?.title)
                binding.tVUserEducation.setText(user.educationStatus)
                binding.tVUserFollowersCount.setText("Друзья \n${user.followersCount}")
                binding.tVUserInterests.setText(user.interests)
                binding.tVUserOnline.setText(if (user.online == 1) "online" else "offline")
                binding.tVUserStatus.setText(user.status)
                binding.tVUserSchools.setText(user.schools.toString())
                binding.tVUserUniversities.setText(user.universities.toString())
                Picasso.with(context).load(user.photo400Orig)
                    .into(binding.iVUserPhoto200)
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
        return binding.root
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