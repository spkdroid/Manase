package com.hedron.meditate.ui.dashboard

import android.graphics.Color
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
        root.datetxt.text = getDateTime()
        root.clockView.setTime(10,10,10)

        root.happyCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.sadCardView.setOnClickListener{
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.angryCardView.setOnClickListener{
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.disgustCardView.setOnClickListener{
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.fearCardView.setOnClickListener{
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.loveCardView.setOnClickListener{
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.supriseCardView.setOnClickListener{
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
        }

        root.sickCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
        }






        return root
    }

    fun getDateTime(): String? {
        val calendar = Calendar.getInstance()
        return DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
    }

}
