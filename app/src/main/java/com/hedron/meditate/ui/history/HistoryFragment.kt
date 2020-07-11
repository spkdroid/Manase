package com.hedron.meditate.ui.history

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.hedron.meditate.R
import com.hedron.meditate.adapter.MoodViewAdapter
import com.hedron.meditate.model.MoodModel
import kotlinx.android.synthetic.main.history_fragment.*
import kotlinx.android.synthetic.main.history_fragment.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    private lateinit var viewModel: HistoryViewModel
    private lateinit var moodModelList: ArrayList<MoodModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v:View =  inflater.inflate(R.layout.history_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)



        moodModelList = ArrayList()
        v.moodItemList.apply {
            adapter = MoodViewAdapter(context, moodModelList)
        }
        GlobalScope.launch {
            viewModel.getOfferList(requireContext())
        }

        v.moodItemList.layoutManager =
            androidx.recyclerview.widget.GridLayoutManager(context, 1)
        v.moodItemList.setHasFixedSize(true)

        // observe the offer list from the view model
        viewModel.moodHistoryList.observe(viewLifecycleOwner, Observer {
            it.forEach { it ->
                moodModelList.add(it)
            }
            if (it.isNotEmpty()) {
                v.moodItemList.adapter!!.notifyDataSetChanged()
            }
        })



        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}
