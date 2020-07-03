package com.hedron.meditate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hedron.meditate.R
import com.hedron.meditate.adapter.MeditationAdapter
import com.hedron.meditate.model.MeditationModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

   // var v: View? = null
   // private val mRecyclerView: RecyclerView? = null
   // private val myAdapter: MeditationAdapter? = null
    private lateinit var listGuides: ArrayList<MeditationModel>

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
       // homeViewModel.text.observe(viewLifecycleOwner, Observer {
       //     textView.text = it
       // })
        /*
        listGuides = ArrayList()
        listGuides.add(MeditationModel("Sleep", "Feel the night. Watch its beauty.", R.drawable.sleep))
        listGuides.add(MeditationModel("Stress & Anxiety", "Soothes your soul.", R.drawable.calm))
        listGuides.add(MeditationModel("Breathe", "Stop, relax and breathe.", R.drawable.nature))
        listGuides.add(MeditationModel("Midnight Thoughts", "Calm your heart.", R.drawable.moon))
        listGuides.add(MeditationModel("Work Out", "Get your heart pumping.", R.drawable.man))
        listGuides.add(MeditationModel("Concentration", "Focus and relax.", R.drawable.mind))
        val recycleradpter = MeditationAdapter(requireContext(), listGuides!!)
        recyclerView.layoutManager = LinearLayoutManager(activity) //create recycler view in linearlayout
        recyclerView.adapter = recycleradpter
         */

        listGuides = ArrayList()
        listGuides.add(MeditationModel("Sleep", "Feel the night. Watch its beauty.", R.drawable.sleep))
        listGuides.add(MeditationModel("Stress & Anxiety", "Soothes your soul.", R.drawable.calm))
        listGuides.add(MeditationModel("Breathe", "Stop, relax and breathe.", R.drawable.nature))
        listGuides.add(MeditationModel("Midnight Thoughts", "Calm your heart.", R.drawable.moon))
        listGuides.add(MeditationModel("Work Out", "Get your heart pumping.", R.drawable.man))
        listGuides.add(MeditationModel("Concentration", "Focus and relax.", R.drawable.mind))
     //   recyclerView.apply {
     //       adapter = MeditationAdapter(this.context, listGuides)
     //   }
        root.recyclerView.adapter = MeditationAdapter(this.requireActivity(),listGuides)
        root.recyclerView.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        root.recyclerView.setHasFixedSize(true)
        return root
    }
}
