package ru.job4j.vkfriendskt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_friends_list.view.*
import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.model.user.VkUser

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class FriendsListAdapter(
    private val itemClick: (VkUser) -> Unit
) :
    RecyclerView.Adapter<FriendsListAdapter.FriendsHolder>() {
    private val friends: ArrayList<VkUser> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendsListAdapter.FriendsHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_friends_list,
            parent, false
        )
        return FriendsListAdapter.FriendsHolder(itemView)
    }

    override fun getItemCount() = friends.size

    override fun onBindViewHolder(holder: FriendsHolder, position: Int) {
        val currentFriend = friends[position]
        holder.setup(currentFriend, itemClick)
    }

    fun setData(friendsList: List<VkUser>) {
        friends.clear()
        friends.addAll(friendsList)
        notifyDataSetChanged()
    }

    class FriendsHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun setup(vkUser: VkUser, itemClick: (VkUser) -> Unit) {
            with(containerView) {
                textViewFirstName.text = vkUser.firstName
                textViewFirstName.text = vkUser.firstName
                textViewLastName.text = vkUser.lastName
                vkUser.photo100.let {

                    val context: Context = imageView.getContext()
                    Picasso.with(context).load(vkUser.photo100)
                        .into(imageView)
                }

                setOnClickListener { itemClick.invoke(vkUser) }
            }
        }


    }




}