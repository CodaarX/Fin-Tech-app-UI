package com.decagon.week4task.data

import android.graphics.Color
import com.decagon.week4task.models.CardModel

class CardList {

    companion  object{

        // function call that returns an array list of data to be used
        fun getCards(): ArrayList<CardModel>{

            // variable to save arrayList of data
            val cardList = ArrayList<CardModel>()

            /**
             * populating the cardList array with card model instances
             * @param CardModel -> references the data class holding required data
             */

            cardList.add(CardModel("Dariot", "45, 934, 762.00",2646, Color.RED))
            cardList.add(CardModel("Michael", "60, 254, 002.00",3634, Color.BLUE))
            cardList.add(CardModel("Desta", "11, 745, 462.00",6534, Color.GRAY))
            cardList.add(CardModel("John", "45, 244, 528.00",3864, Color.RED))
            cardList.add(CardModel("Riley", "83, 766, 752.00",8365, Color.BLUE))
            cardList.add(CardModel("Bash", "15, 625, 042.00",3546, Color.BLACK))

            return cardList
        }
    }
}