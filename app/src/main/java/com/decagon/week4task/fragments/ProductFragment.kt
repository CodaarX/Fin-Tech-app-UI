package com.decagon.week4task.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.decagon.week4task.data.CardList
import com.decagon.week4task.R
import com.decagon.week4task.data.RecyclerViewCardList
import com.decagon.week4task.adapters.RecyclerViewAdapter
import com.decagon.week4task.adapters.VisaViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class ProductFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // restors saved data to ensure persistency
        savedInstanceState?.let {

            // get saved data by key
            val savedINT = it.getString("DATA_STRING")
            var savedSTR = it.getInt("DATA_INT")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /**
         * for your viewpager, you need 3 things. your data, your adapter and your viewpager layout
         */

        /**
         * The below code controls the logic for recycler view
         */

        //save all cards / data generated from cardlist data class to card variable.
        val cards = CardList.getCards()

        // calls the VisaViewPagerAdapter class and passes the list as parameter into it for binding
        val viewPagerAdapter = VisaViewPagerAdapter(cards)

        // declare the variable to hold viewpager
        lateinit var viewPager: ViewPager2

        // get viewpager layout and save to variable
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        // save viewpager layout to variable
        viewPager = view.findViewById(R.id.viewPagerContainer)

        // set viewpager adapter to created adapter class referenced in line 5
        viewPager.adapter = viewPagerAdapter

        // set viewpager properties
        viewPager.setPadding(100, 0, 100, 0)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

        // call the composite page transformer class and set to viewpager ------ question
        val viewPagerTransformer = CompositePageTransformer()

        // set viewpager transform properties
        viewPagerTransformer.addTransformer(MarginPageTransformer(5))
        viewPagerTransformer.addTransformer{page, position -> val pos = 1 - kotlin.math.abs(position)
        page.scaleY = 0.75f + pos * 0.19f
        }

        // set transform properties to viewpager of choice
        viewPager.setPageTransformer(viewPagerTransformer)

        /**
         * The below code controls the logic for recycler view
         */

        // get data for recyclerView and save to recycler list
        val recyclerList = RecyclerViewCardList.getRecyclerList()

        // get recycle list adapter and pass in data to be binded, save in a variable
        val recyclerViewListAdapter = RecyclerViewAdapter(recyclerList)

        // get recyclerView manager that sets orientation of the recycler view vertically or horizontally,
        val recycleManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false )

        // get the recycler view layout from xml
        val myRecyclerLayout: RecyclerView = view.findViewById(R.id.recyclerLayout)

        // set the layout to the orientation configured
        myRecyclerLayout.layoutManager = recycleManager

        // set the recycler view adapter to the recyclerview layout
        myRecyclerLayout.adapter = recyclerViewListAdapter

        // set properties to recyclerview layout
        myRecyclerLayout.clipChildren = false
        myRecyclerLayout.clipToPadding = false
        myRecyclerLayout.setPadding(30, 10, 30,10)

        // get the tab layout with the Tab layout mediator class
        TabLayoutMediator(view.findViewById(R.id.tabLayout), viewPager){
            tab, position -> tab.icon = resources.getDrawable(R.drawable.active_dot)
        }.attach()

        // variable for the number dots gotten by counting the number of items in the layer to be bounded with - (viewpager)
        val dotscount = viewPagerAdapter.itemCount

        // create an array for the number of dots required by tab layout
        val dotsArray = arrayOfNulls<ImageView>(dotscount)

        // loop through the range of number of items in adapter
            for (i in 0 until dotscount) {

                // get each imageVIew and correspond to each dot
                dotsArray[i] = ImageView(requireContext())

                // set each dot to its defined drawable
                dotsArray[i]!!.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.non_active_dot))
            }
            // return recycler view
            return view
        }

}