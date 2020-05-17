package com.example.challenge2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.ScrollingTabContainerView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_covid_prov_item.*
import java.util.*

class CovidProvAdapter(private val context: Context, private val items:
List<CovidProvItem>, private val listener: (CovidProvItem) -> Unit) :
RecyclerView.Adapter<CovidProvAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.activity_covid_prov_item,
            parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView: View):
            RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item:CovidProvItem, listener: (CovidProvItem) -> Unit) {
            txtProv.text =item.attributes.provinsi
            txtPositif.text = item.attributes.kasusPosi.toString()
            txtSembuh.text = item.attributes.kasusSemb.toString()
            txtMeninggal.text = item.attributes.kasusMeni.toString()

            containerView.setOnClickListener { listener(item) }
        }
    }
}