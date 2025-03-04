package com.dija.manase.ui.view

import android.graphics.BitmapFactory
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.dija.manase.databinding.FragmentMusicBinding
import com.dija.manase.ui.viewmodel.MusicViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicFragment : Fragment() {
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding  // Safe getter

    private val viewModel: MusicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding!!.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("title") ?: ""
        val desc = arguments?.getString("description") ?: ""
        val imageByte = arguments?.getByteArray("image")

        binding?.let { safeBinding ->
            safeBinding.meditateTitleTxt.text = "$title\n$desc"
        }

        imageByte.let {
            binding?.meditateImageView?.setImageBitmap(
                BitmapFactory.decodeByteArray(
                    it,
                    0,
                    it!!.size
                )
            )
        }

        binding?.headerCard?.setCardBackgroundColor(ContextCompat.getColor(requireContext(), androidx.cardview.R.color.cardview_dark_background))

        viewModel.isMusicPlaying.observe(viewLifecycleOwner) {
            binding?.playPauseImg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), if (it) android.R.drawable.ic_media_pause else android.R.drawable.ic_media_play)
            )
        }

        binding?.playCard?.setOnClickListener {
            lifecycleScope.launch {
                viewModel.toggleMusic(title)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}