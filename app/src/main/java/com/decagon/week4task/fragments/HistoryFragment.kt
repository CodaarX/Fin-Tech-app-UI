package com.decagon.week4task.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decagon.week4task.R

class HistoryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // recovers data to ensure persistency
        savedInstanceState ?.let {
            val savedINT = it.getString("DATA_STRING")
            var savedSTR = it.getInt("DATA_INT")
        }
    }


    // create fragment view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    // saves data to ensure persistency
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("DATA-INT", 34)
        outState.putString("DATA-STRING", "data")
    }

}