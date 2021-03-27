package com.willyweather.assignment.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.willyweather.assignment.R
import com.willyweather.assignment.data.model.TeamsItem
import com.willyweather.assignment.databinding.TeamsItemBinding

class TeamsListAdapter(private val listener: ItemClickListener) :
    RecyclerView.Adapter<TeamsListAdapter.ItemViewHolder>() {

    private var items = ArrayList<TeamsItem>()

    interface ItemClickListener {
        fun onItemClick(teamId: Int)
    }

    fun setItems(teamList: List<TeamsItem>?) {
        if (teamList != null) {
            items.clear()
            items.addAll(teamList)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: TeamsItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.teams_item,
            parent,
            false
        )

        return ItemViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ItemViewHolder(val binding: TeamsItemBinding, val listener: ItemClickListener) :
        RecyclerView.ViewHolder(
            binding.root
        ), View.OnClickListener {

        private var teamId: Int? = null

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: TeamsItem) {
            teamId = item.id
            binding.team = item
        }

        override fun onClick(v: View?) {
            if (teamId != null) {
                listener.onItemClick(teamId!!);
            }
        }

    }
}