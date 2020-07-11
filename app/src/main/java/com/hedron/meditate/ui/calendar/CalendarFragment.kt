package com.hedron.meditate.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.hedron.meditate.Constant
import com.hedron.meditate.R
import com.vivekkaushik.datepicker.OnDateSelectedListener
import kotlinx.android.synthetic.main.calendar_fragment.*
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
        viewModel = ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        val calendar: Calendar = Calendar.getInstance()
        var date: SimpleDateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val dayName: String = date.format(calendar.getTime()) //Monday

        date = SimpleDateFormat("dd", Locale.getDefault())
        val dayNumber: String = date.format(calendar.getTime()) //20

        date = SimpleDateFormat("MM", Locale.getDefault())
        val monthNumber: String = date.format(calendar.getTime()) //04

        date = SimpleDateFormat("yyyy", Locale.getDefault())
        val year: String = date.format(calendar.getTime()) //2020

        viewModel.moodHistoryForDate.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if(it.isNotEmpty()) {

                resetGridView()

                var happyFrq = 0
                var sadFrq = 0
                var angryFrq = 0
                var disgustFrq = 0
                var fearFrq = 0
                var loveFrq = 0
                var supriseFrq = 0
                var sickFrq = 0

                it.forEach {
                    when(it.type) {
                          Constant.Happy -> {
                              happyFrq++
                              happyFreq.text = happyFrq.toString() +" "+ Constant.Happy
                          }
                          Constant.Sad -> {
                              sadFrq++
                              sadFreq.text = sadFrq.toString() +" "+ Constant.Sad
                          }
                          Constant.Angry -> {
                              angryFrq++
                              angryFreq.text = angryFrq.toString() +" "+ Constant.Angry
                          }
                          Constant.Disgust -> {
                              disgustFrq++
                              disgustFreq.text = disgustFrq.toString() +" "+ Constant.Disgust
                          }
                          Constant.Fear -> {
                              fearFrq++
                              fearFreq.text = fearFrq.toString() +" "+ Constant.Fear
                          }
                          Constant.Sick -> {
                              sickFrq++
                              sickFreq.text = sickFrq.toString() +" "+ Constant.Sick
                          }
                          Constant.Suprise -> {
                              supriseFrq++
                              supriseFreq.text = supriseFrq.toString() +" "+ Constant.Suprise
                          }
                          Constant.Love -> {
                              loveFrq++
                              loveFreq.text = loveFrq.toString() +" "+ Constant.Love
                          }
                    }
                }
            } else {
                resetGridView()
            }
        })

        v.datePickerTimeline.setInitialDate(year.toInt(),monthNumber.toInt()-1,dayNumber.toInt()-3)

        var d:Calendar = Calendar.getInstance()
        v.datePickerTimeline.setActiveDate(d)
        v.datePickerTimeline.setOnDateSelectedListener(object : OnDateSelectedListener {

            override fun onDateSelected(year: Int, month: Int, day: Int, dayOfWeek: Int) {
                // Do Something
                var m = month+1
                var s = ""

                if(m<10)
                s = "$day/0$m/$year"
                else
                s = "$day/$m/$year"

                viewModel.getMoodStatsForDate(requireContext(),s)
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

    private fun resetGridView() {
        happyFreq.text = Constant.Happy
        sadFreq.text = Constant.Sad
        angryFreq.text = Constant.Angry
        disgustFreq.text =  Constant.Disgust
        fearFreq.text =  Constant.Fear
        sickFreq.text =  Constant.Sick
        supriseFreq.text =  Constant.Suprise
        loveFreq.text = Constant.Love
    }

    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        // TODO: Use the ViewModel
    }*/
}
