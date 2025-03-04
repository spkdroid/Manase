package com.dija.manase.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dija.manase.data.adapter.MeditationAdapter
import com.dija.manase.databinding.FragmentMainBinding
import com.dija.manase.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding  // Safe getter

  private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.meditationList.observe(viewLifecycleOwner) { list ->
            binding?.let { safeBinding ->
                safeBinding.recyclerView.apply {
                    adapter = MeditationAdapter(list)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    setHasFixedSize(true)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
      _binding = FragmentMainBinding.inflate(inflater, container, false)
      return binding!!.root
  }
}
