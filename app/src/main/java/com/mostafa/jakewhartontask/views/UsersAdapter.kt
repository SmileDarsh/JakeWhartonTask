package com.mostafa.jakewhartontask.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mostafa.jakewhartontask.R
import com.mostafa.jakewhartontask.data.model.UserOwner
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mUsers = mutableListOf<UserOwner>()
    private val VIEW_TYPE_NORMAL = 0
    private val VIEW_TYPE_LOADING = 1
    private var isLoading = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_NORMAL)
            return UserViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_user,
                    parent,
                    false
                )
            )
        else {
            return LoadingViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_progress,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.bindView(mUsers[position])
        }
    }

    override fun getItemCount(): Int = mUsers.size

    override fun getItemViewType(position: Int): Int {
        return if (isLoading)
            if (position == mUsers.size - 1) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
        else
            VIEW_TYPE_NORMAL
    }

    fun setUser(user: MutableList<UserOwner>) {
        if (user.size != 0) {
            isLoading = true
            val count = itemCount
            mUsers.addAll(user)
            notifyItemRangeInserted(count, user.size)
        } else {
            isLoading = false
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mCivOwner: CircleImageView = itemView.civOwner
        private val mTvOwnerName: TextView = itemView.tvOwnerName
        private val mTvOwnerUrl: TextView = itemView.tvOwnerUrl
        private val mTvUserName: TextView = itemView.tvUserName
        private val mTvUserLanguage: TextView = itemView.tvUserLanguage
        private val mTvUserDescription: TextView = itemView.tvUserDescription
        private val mTvUserUrl: TextView = itemView.tvUserUrl

        fun bindView(item: UserOwner) {
            Glide.with(itemView.context)
                .load(item.owner!!.image)
                .into(mCivOwner)

            mTvOwnerName.text = item.owner!!.name
            mTvOwnerUrl.text = item.owner!!.htmlUrl
            mTvUserName.text = item.user!!.name
            mTvUserLanguage.text = item.user!!.language
            mTvUserDescription.text = item.user!!.description
            mTvUserUrl.text = item.user!!.htmlUrl
        }
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}