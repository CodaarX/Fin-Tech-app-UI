package com.decagon.week4task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.week4task.R
import com.decagon.week4task.models.RecyclerViewCardsModel

/**
 * @param recyclerList -> the list / data to be displayed in the recycler view
 * @param
 */

class RecyclerViewAdapter (
        private val recyclerList: ArrayList<RecyclerViewCardsModel>
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>() {

    inner class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // creates the number of viewHolders that holds the data to be displayed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {

        // recyclerView variable holds the inflated recycler view layout
        val recyclerView = LayoutInflater.from(parent.context).inflate(R.layout.partners, parent, false)

        // returns the recycler view layout to be displayed in the viewholder
        return RecyclerViewViewHolder(recyclerView)
    }

    // binds data to be displayed to each view holder created
    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.recycle_call_out).text = recyclerList[position].callouts
            findViewById<TextView>(R.id.recycle_percent).text = recyclerList[position].discounts
            findViewById<TextView>(R.id.recycle_categories).text = recyclerList[position].categories
            findViewById<ImageView>(R.id.recycle_imageView).setImageResource(recyclerList[position].image)
        }
    }

    // gets the count of data to be used for binding
    override fun getItemCount(): Int {
        return recyclerList.size
    }
}
