package com.decagon.week4task.data

import com.decagon.week4task.R
import com.decagon.week4task.models.RecyclerViewCardsModel

class RecyclerViewCardList {
    companion object{

        // function call that returns an array list of data to be used
        fun getRecyclerList(): ArrayList<RecyclerViewCardsModel>{
            // variable to save arrayList of data
            val recyclerViewList = ArrayList<RecyclerViewCardsModel>()


            /**
             * populating the cardList array with card model instances
             * @param CardModel -> references the data class holding required data
             */
            recyclerViewList.add(RecyclerViewCardsModel("Ali Express","from 4%","Clothes and Shoes", R.drawable.ic_shopping_bag_1))
            recyclerViewList.add(RecyclerViewCardsModel("Avia Sales","from 4.4%","Tickets and Travels", R.drawable.ic_shopping_bag_2))
            recyclerViewList.add(RecyclerViewCardsModel("Book Gram","from 4%","Booking", R.drawable.ic_shopping_bag_1))

            return recyclerViewList
        }
    }
}