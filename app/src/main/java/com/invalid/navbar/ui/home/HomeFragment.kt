package com.invalid.navbar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.invalid.navbar.R
import com.invalid.navbar.data.Dumm.listCategory
import com.invalid.navbar.databinding.FragmentHomeBinding
import com.invalid.navbar.ui.home.adapter.AdapterCat

class HomeFragment : Fragment() {

	private var viewModel = HomeViewModel()
	private val adapterCat = AdapterCat()

	private var _binding: FragmentHomeBinding? = null

	// This property is only valid between onCreateView and
	// onDestroyView.
	private val binding get() = _binding!!


	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val homeViewModel =
			ViewModelProvider(this).get(HomeViewModel::class.java)

		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		val root: View = binding.root

		val textView: TextView = binding.textHome
		homeViewModel.text.observe(viewLifecycleOwner) {
			textView.text = it
		}

		setData()
		setAdapter()
		return root
	}

	private fun setAdapter(){
		binding.hrvCategory.adapter = adapterCat
	}
	private fun setData() {
		viewModel.listCategory.observe(requireActivity(), {
			adapterCat.addItems(it)
		})
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}