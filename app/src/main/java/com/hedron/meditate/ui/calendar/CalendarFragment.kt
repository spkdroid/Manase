package com.hedron.meditate.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.anychart.AnyChart.pie
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.hedron.meditate.util.Constant
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
        var date = SimpleDateFormat("EEEE", Locale.getDefault())
        date.format(calendar.time) //Monday

        date = SimpleDateFormat("dd", Locale.getDefault())
        val dayNumber: String = date.format(calendar.time) //20

        date = SimpleDateFormat("MM", Locale.getDefault())
        val monthNumber: String = date.format(calendar.time) //04

        date = SimpleDateFormat("yyyy", Locale.getDefault())
        val year: String = date.format(calendar.time) //2020

        val pie = pie()

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

                v.any_chart_view.invalidate()
                val data: MutableList<DataEntry> = ArrayList()
                data.add(ValueDataEntry("Happy", happyFrq))
                data.add(ValueDataEntry("Sad", sadFrq))
                data.add(ValueDataEntry("Angry", angryFrq))
                data.add(ValueDataEntry("Disgust", disgustFrq))
                data.add(ValueDataEntry("Fear", fearFrq))
                data.add(ValueDataEntry("Sick", sickFrq))
                data.add(ValueDataEntry("Suprise", supriseFrq))
                data.add(ValueDataEntry("Love", loveFrq))
                pie.data(data)

            } else {
                v.any_chart_view.invalidate()
                resetGridView()
            }
        })

        v.datePickerTimeline.setInitialDate(year.toInt(),monthNumber.toInt()-2,dayNumber.toInt()-30)

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


        pie.title("Mood Chart")
        pie.labels().position("outside")
        pie.legend().title().enabled(true)
        pie.legend().title()
            .text("Mood Frequency")
            .padding(0.0, 0.0, 10.0, 0.0)
        v.any_chart_view.setChart(pie)
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

}
