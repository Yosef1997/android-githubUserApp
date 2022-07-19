package com.example.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.CharacterData
import org.w3c.dom.Text

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder> () {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(username, name, location, repository, company, followers, following, avatar) = listUser[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvUserName.text = username
        holder.tvName.text = name
        holder.tvLocation.text = location
        holder.tvRepository.text = repository
        holder.tvCompany.text = company
        holder.tvFollowers.text = followers
        holder.tvFollowing.text = following
        holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUserName: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        var tvRepository: TextView = itemView.findViewById(R.id.tv_item_repository)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        var tvFollowers: TextView = itemView.findViewById(R.id.tv_item_followers)
        var tvFollowing: TextView = itemView.findViewById(R.id.tv_item_following)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: User)
    }
}