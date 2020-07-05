package com.hedron.meditate.ui.music

import android.graphics.BitmapFactory
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
        viewModel = ViewModelProviders.of(this).get(MusicViewModel::class.java)
        var v =  inflater.inflate(R.layout.music_fragment, container, false)

        var title = arguments?.get("title").toString()
        var desc = arguments?.get("description").toString()
        var imageByte = arguments?.get("image") as ByteArray

        v.meditateTitleTxt.text = title + "\n" + desc
        v.meditateImageView.setImageBitmap(BitmapFactory.decodeByteArray(imageByte,0,imageByte.size))
        v.headerCard.setCardBackgroundColor(Color.parseColor("#FAEDCB"))

        return v
    }

}
