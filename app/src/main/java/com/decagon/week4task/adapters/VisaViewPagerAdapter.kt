package com.decagon.week4task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.week4task.R
import com.decagon.week4task.models.CardModel

class VisaViewPagerAdapter (
        private val cardList: ArrayList<CardModel>
        ) : RecyclerView.Adapter<VisaViewPagerAdapter.VisaViewPagerViewHolder>() {
            inner class VisaViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    // creates the number of viewHolders that holds the data to be displayed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisaViewPagerViewHolder {

        // cardView variable holds the inflated recycler view layout
        val cardView =  LayoutInflater.from(parent.context).inflate(R.layout.card_container, parent, false)

        // returns the view pager layout to be displayed in the viewholder
        return VisaViewPagerViewHolder(cardView)
    }

    // binds data to be displayed to each view holder created
    override fun onBindViewHolder(holder: VisaViewPagerViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.cardName).text = cardList[position].name
            findViewById<TextView>(R.id.cardMoney).text = cardList[position].money
            findViewById<TextView>(R.id.cardPin).text = cardList[position].pin.toString()
            findViewById<CardView>(R.id.cardView1).setCardBackgroundColor(cardList[position].color)
        }
    }

    // gets the count of data to be used for binding
    override fun getItemCount(): Int {
        return cardList.size
    }
}