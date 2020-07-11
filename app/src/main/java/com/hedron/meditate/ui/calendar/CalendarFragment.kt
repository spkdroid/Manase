package com.hedron.meditate.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hedron.meditate.R
import com.vivekkaushik.datepicker.OnDateSelectedListener
import kotlinx.android.synthetic.main.calendar_fragment.view.*
import java.text.SimpleDateFormat
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

        val calendar: Calendar = Calendar.getInstance()
        var date: SimpleDateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val dayName: String = date.format(calendar.getTime()) //Monday

        date = SimpleDateFormat("dd", Locale.getDefault())
        val dayNumber: String = date.format(calendar.getTime()) //20

        date = SimpleDateFormat("MM", Locale.getDefault())
        val monthNumber: String = date.format(calendar.getTime()) //04

        date = SimpleDateFormat("yyyy", Locale.getDefault())
        val year: String = date.format(calendar.getTime()) //2020

        v.datePickerTimeline.setInitialDate(year.toInt(),monthNumber.toInt()-1,dayNumber.toInt()-3)

        v.datePickerTimeline.setOnDateSelectedListener(object : OnDateSelectedListener {
            override fun onDateSelected(year: Int, month: Int, day: Int, dayOfWeek: Int) {
                // Do Something
                var m = month+1
                var s = "$year-($m)-$day"
                Toast.makeText(requireContext(),s,Toast.LENGTH_LONG).show()
            }

            override fun onDisabledDateSelected(
                year: Int,
                month: Int,
                day: Int,
                dayOfWeek: Int,
                isDisabled: Boolean
            ) {
                // Do Something
            }
        })


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
