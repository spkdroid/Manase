package com.dija.manase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dija.manase.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

  companion object {
    fun newInstance() = MainFragment()
  }
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!  // Safe getter

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // TODO: Use the ViewModel
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
      _binding = FragmentMainBinding.inflate(inflater, container, false)
      return binding.root
  }
}
