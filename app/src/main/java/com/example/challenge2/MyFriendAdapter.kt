package com.example.challenge2

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.my_friend_item.*

class MyFriendAdapter(private  val context: Context, private val item: ArrayList<MyFriend>) :
RecyclerView.Adapter<MyFriendAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(context).inflate(R.layout.my_friend_item,parent,false)
    )

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MyFriendAdapter.ViewHolder, position: Int) {
        holder.bindItem(item.get(position))
    }

    class ViewHolder(override val containerView:View):
            RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: MyFriend){
            txtFieldNama.text = item.nama
            txtFieldEmail.text = item.email
            txtFieldTelp.text = item.telp
        }
    }

}