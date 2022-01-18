package com.affinityapps.stattext.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stattext.R
import com.affinityapps.stattext.databinding.DataListItemsBinding

class HomeAdapter(
    private val homeFragmentArrayList: List<Contacts>,
) :
    RecyclerView.Adapter<HomeAdapter.HomeFragmentViewHolder>() {
    private var rowIndex: Int = -1


    inner class HomeFragmentViewHolder(binding: DataListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var nameTextView: TextView = binding.dataName
        var numberTextView: TextView = binding.dataNumber

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFragmentViewHolder {
        return HomeFragmentViewHolder(
            DataListItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeFragmentViewHolder, position: Int) {

        val contacts: Contacts = homeFragmentArrayList[position]
        holder.nameTextView.text = contacts.name
        holder.numberTextView.text = contacts.number
    }

    override fun getItemCount() = homeFragmentArrayList.size
}
