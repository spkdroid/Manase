package com.hedron.meditate.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hedron.meditate.Constant
import com.hedron.meditate.R
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.MoodRepository
import com.hedron.meditate.repository.database.MoodDatabase
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

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

        val milliseconds = System.currentTimeMillis()
        var hour = ((milliseconds / (1000*60*60)) % 24).toInt()
        var min =  ((milliseconds / (1000*60)) % 60).toInt()
        var sec = ((milliseconds / 1000) % 60).toInt()
        root.clockView.setTime(hour, min, sec)
        var selectedMood = "";

        root.happyCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Happy
        }

        root.sadCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Sad
        }

        root.angryCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Angry
        }

        root.disgustCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Disgust
        }

        root.fearCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Fear
        }

        root.loveCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Love
        }

        root.supriseCardView.setOnClickListener {
            root.happyCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.sadCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.angryCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.disgustCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.fearCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.loveCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            root.supriseCardView.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
            root.sickCardView.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
            selectedMood = Constant.Suprise
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
            selectedMood = Constant.Sick
        }


        root.saveCard.setOnClickListener {
            if(selectedMood.isNotEmpty() && dialogEditTxt.text!!.isNotEmpty()) {
//                Toast.makeText(requireContext(),selectedMood,Toast.LENGTH_LONG).show()
//                Toast.makeText(requireContext(),dialogEditTxt.text,Toast.LENGTH_LONG).show()



                GlobalScope.launch {
               //     var size = repository.allMoods.value!!.size
                    val moodDao = MoodDatabase.getDatabase(requireContext()).moodDaoAccess()
                    var repository = MoodRepository(moodDao)
                    var size = repository.getAll().size
                    repository.insert(MoodModel(repository.getAll().size+1,selectedMood.toString(),getDateTime().toString(),dialogEditTxt.text.toString()))
                }


                //var allMoods = repository.allMoods
            } else {
                Toast.makeText(requireContext(),"Input Error",Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    fun getDateTime(): String? {
        val calendar = Calendar.getInstance()
        return DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
    }

}