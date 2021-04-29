package com.decagon.week4task

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.decagon.week4task.fragments.MoreFragment
import com.decagon.week4task.fragments.PaymentFragment
import com.decagon.week4task.fragments.ProductFragment
import com.decagon.week4task.fragments.SupportFragment
import com.decagon.week4task.fragments.HistoryFragment

object Navigation {

    // function to lunch fragment swap
    private fun lunchFragment(supportFragmentManager: FragmentManager, fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                .apply {

                    // replaces fragment frame content with required fragment
                    replace(R.id.fragmentFrame, fragment)
                    commit()
                }
    }

    /**
     * functions below respond to calls from the product fragment
     * and makes calls to lunch fragment above.
     */

    fun openHistory(supportFragmentManager: FragmentManager) {
        lunchFragment(supportFragmentManager, HistoryFragment())
    }

    fun openProduct(supportFragmentManager: FragmentManager) {
        lunchFragment(supportFragmentManager, ProductFragment())
    }

    fun openPayment(supportFragmentManager: FragmentManager) {
        lunchFragment(supportFragmentManager, PaymentFragment())
    }

    fun openSupport(supportFragmentManager: FragmentManager) {
        lunchFragment(supportFragmentManager, SupportFragment())
    }

    fun openMore(supportFragmentManager: FragmentManager) {
        lunchFragment(supportFragmentManager, MoreFragment())
    }
}