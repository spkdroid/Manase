package com.hedron.meditate.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hedron.meditate.R
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import java.text.DateFormat
import java.util.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
       // val textView: TextView = root.findViewById(R.id.text_dashboard)
       // dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
       //     textView.text = it
       //
        // })
        root.datetxt.text = getDateTime();
        return root
    }

    fun getDateTime(): String? {
        val calendar = Calendar.getInstance()
        return DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
    }

}
