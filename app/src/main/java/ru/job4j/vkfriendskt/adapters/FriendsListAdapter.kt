package ru.job4j.vkfriendskt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.job4j.vkfriendskt.R
import ru.job4j.vkfriendskt.model.user.VkUser

/**
 * @author Dmitry Kolganov (mailto:dmk78@inbox.ru)
 * @version $Id$
 * @since 05.02.2020
 */

class FriendsListAdapter(
val callback: Callback
) :
    RecyclerView.Adapter<FriendsListAdapter.FriendsHolder>() {

    private val friends: ArrayList<VkUser> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FriendsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_friends_list,
                parent,
                false
            )
        )


    override fun getItemCount()= friends.size


    override fun onBindViewHolder(holder: FriendsHolder, position: Int) {
    holder.bind(friends.get(position))}

    fun setData(friendsList: List<VkUser>) {
        friends.clear()
        friends.addAll(friendsList)
        notifyDataSetChanged()
    }


    inner class FriendsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewFirstName: TextView = itemView.findViewById(R.id.textViewFirstName)
        var textViewLastName: TextView= itemView.findViewById(R.id.textViewLastName)
        var imageViewPhoto: ImageView= itemView.findViewById(R.id.imageView)
        var view: View = itemView

        fun bind(friend: VkUser) {


            textViewFirstName.text = friend.firstName
            textViewLastName.text = friend.lastName
            friend.photo100.let {

                val context: Context = imageViewPhoto.getContext()
                Picasso.with(context).load(friend.photo100)
                    .into(imageViewPhoto)
            }
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(friends.get(adapterPosition))
            }

        }
    }

    interface Callback {
        fun onItemClicked(item: VkUser)
    }


}