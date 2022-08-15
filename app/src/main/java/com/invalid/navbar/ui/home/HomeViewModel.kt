package com.invalid.navbar.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.invalid.navbar.data.Dumm
import com.invalid.navbar.model.Cate

class HomeViewModel : ViewModel() {

	private val _text = MutableLiveData<String>().apply {
		value = "This is home Fragment"
	}
	val text: LiveData<String> = _text

	val listCategory: LiveData<List<Cate>> = MutableLiveData<List<Cate>>().apply {
		value = Dumm.listCategory
	}
}