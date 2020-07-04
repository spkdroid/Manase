package com.hedron.meditate.ui.music

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hedron.meditate.R
import kotlinx.android.synthetic.main.music_fragment.view.*

class MusicFragment : Fragment() {

    companion object {
        fun newInstance() = MusicFragment()
    }

    private lateinit var viewModel: MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v =  inflater.inflate(R.layout.music_fragment, container, false)
        v.headerCard.setCardBackgroundColor(Color.parseColor("#FAEDCB"))


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MusicViewModel::class.java)
        // TODO: Use the ViewModel
        //iconCard.setCardBackgroundColor(Color.parseColor("#FAEDCB"));

    }

}
