package com.hedron.meditate.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hedron.meditate.R
import devs.mulham.horizontalcalendar.HorizontalCalendar
import kotlinx.android.synthetic.main.calendar_fragment.*
import kotlinx.android.synthetic.main.calendar_fragment.view.*
import java.util.*


class CalendarFragment : Fragment() {

    companion object {
        fun newInstance() = CalendarFragment()
    }

    private lateinit var viewModel: CalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v =  inflater.inflate(R.layout.calendar_fragment, container, false)

        /* starts before 1 month from now */
        /* starts before 1 month from now */
        val startDate: Calendar = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

/* ends after 1 month from now */

/* ends after 1 month from now */
        val endDate: Calendar = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)




        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
