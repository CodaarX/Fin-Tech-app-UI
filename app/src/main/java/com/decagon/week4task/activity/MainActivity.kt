package com.decagon.week4task.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.decagon.week4task.Navigation
import com.decagon.week4task.R
import com.decagon.week4task.fragments.ProductFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * @param MenuItem -> holds the value of the targeted menu item
     */

    // set a key to channel_id variable
    private val CHANNEL_ID = "KEY"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // replace the frame layout with desired fragment when application starts
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                .apply {
                    replace(R.id.fragmentFrame, ProductFragment())
                    commit()
                }

        setContentView(R.layout.activity_main)

        // create notification
        createNotificationChannel()

        // call notification when bell icon is clicked
        bell.setOnClickListener {
            callNotification()
        }
    }

    /**
     * The functions below are linked to menu items in the menu resource.
     * they open different fragments when menu is clicked, each references Navigation class for the logic.
     */
    fun openHistory(item: MenuItem) {
        Navigation.openHistory(supportFragmentManager)
    }

    fun openProduct(item: MenuItem) {
        Navigation.openProduct(supportFragmentManager)
    }

    fun openPayment(item: MenuItem) {
        Navigation.openPayment(supportFragmentManager)
    }

    fun openSupport(item: MenuItem) {
        Navigation.openSupport(supportFragmentManager)
    }

    fun openMore(item: MenuItem) {
        Navigation.openMore(supportFragmentManager)
    }


    // function to call notification
    private fun callNotification() {
        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        // set the message to transfer to the next Activity
        intent.putExtra("MESSAGE", "Active")

        // pending intent sets the activity to be lunched when notification is clicked
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        // set notification with custom properties
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("Notification Title")
                .setContentText("Click me to reveal next intent")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will lunch when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        // build the notification created above
        with(NotificationManagerCompat.from(this)) {
            notify(0, builder.build())
        }
    }

    private fun createNotificationChannel() {
        /**
         * @param name -> sets channel name
         * @param description -> channel description
         * @param importance -> importance level of notification
         * @param channel -> create a new channel notification object and applies description
         * channel only works with API 26 and above so this  condition checks that and applies necessary variables abd logic
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // set notification name
            val name = getString(R.string.channel_name)

            // set description text
            val descriptionText = getString(R.string.channel_description)

            // set notidication importance level
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            // create an instance of new channel
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Register the notification channel with the system
            val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }

//    override fun onBackPressed(){
//        var backpress = backpress + 1
//
//        // replace the frame layout with desired fragment when application starts
//        supportFragmentManager.beginTransaction()
//                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
//                .apply {
//                    replace(R.id.fragmentFrame, ProductFragment())
//                    commit()
//                }
//
//        if (backpress>1) {
//            this.finish();
//            }
//        }
    }


