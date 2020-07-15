package com.hedron.meditate.ui.music

import android.content.res.AssetFileDescriptor
import android.graphics.BitmapFactory
import android.graphics.Color
import android.icu.text.CaseMap
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.ybq.android.spinkit.style.*
import com.hedron.meditate.R
import kotlinx.android.synthetic.main.music_fragment.view.*
import java.lang.Exception

class MusicFragment : Fragment() {

    companion object {
        fun newInstance() = MusicFragment()
    }

    private lateinit var viewModel: MusicViewModel
    private  var mediaPlayer:MediaPlayer = MediaPlayer()
    private lateinit var descriptor: AssetFileDescriptor

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

        try {

            when(title) {
                "Sleep" -> {
                    descriptor = requireContext().assets.openFd("thunder.mp3")
                    v.spin_kit.setIndeterminateDrawable(DoubleBounce())
                }
                "Self care" -> {
                    descriptor = requireContext().assets.openFd("nature.mp3")
                    v.spin_kit.setIndeterminateDrawable(Wave())
                }
                 "Breathe" -> {
                     descriptor = requireContext().assets.openFd("breath.mp3")
                     v.spin_kit.setIndeterminateDrawable(WanderingCubes())
                 }
                "Veena" -> {
                    descriptor = requireContext().assets.openFd("veena.mp3")
                    v.spin_kit.setIndeterminateDrawable(CubeGrid())
                }
                "Piano" -> {
                    descriptor = requireContext().assets.openFd("piano.mp3")
                    v.spin_kit.setIndeterminateDrawable(FoldingCube())
                }
            }
            //descriptor = requireContext().assets.openFd("thunder.mp3")
            mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(
                descriptor.fileDescriptor,
                descriptor.startOffset,
                descriptor.length
            )
            mediaPlayer.isLooping = true
            mediaPlayer.prepare()
            descriptor.close()
        } catch (e:Exception) {

        }


        v.playCard.setOnClickListener {
            if(mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                v.spin_kit.visibility = View.INVISIBLE
            } else {
                mediaPlayer.start()
                v.spin_kit.visibility = View.VISIBLE
            }
        }

        return v
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}
