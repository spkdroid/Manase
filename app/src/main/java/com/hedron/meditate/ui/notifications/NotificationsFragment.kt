package com.hedron.meditate.ui.notifications

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.hedron.meditate.R
import kotlinx.android.synthetic.main.fragment_notifications.view.*


class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
     //   val textView: TextView = root.findViewById(R.id.text_notifications)
    //    notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
    //        textView.text = it
    //    })

        root.moodHistoryButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_historyFragment)
        }

        root.moodCalendarButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_calendarFragment)
        }

        root.moodNotificationButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_timeFragment)
        }

        root.breathButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_breathFragment)
        }

        root.feedbackButton.setOnClickListener{
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=com.hedron.meditate")
                    )
                )
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=com.hedron.meditate")
                    )
                )
            }
        }

        return root
    }
}
