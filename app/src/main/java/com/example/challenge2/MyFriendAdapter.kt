package com.example.challenge2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.my_friend_item.*

class MyFriendAdapter(private val context: Context, private val items: ArrayList<CovidIndoItem>,
        private val listener:(CovidIndoItem)-> Unit): RecyclerView.Adapter<MyFriendAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        context, LayoutInflater.from(context).inflate(R.layout.my_friend_item,parent,false)
    )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }

    class ViewHolder(val context:Context, override val containerView:View):
            RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: CovidIndoItem, listener:(CovidIndoItem) -> Unit){
            txtFieldNama.text = item.positif
            txtFieldEmail.text = item.sembuh
            txtFieldTelp.text = item.meninggal

            containerView.setOnClickListener { listener(item) }
        }
    }

}