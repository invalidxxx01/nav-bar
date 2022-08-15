package com.invalid.navbar.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invalid.navbar.databinding.CategoryBinding
import com.invalid.navbar.model.Cate

class AdapterCat : RecyclerView.Adapter<AdapterCat.ViewHolder>() {
	private val data = ArrayList<Cate>()
	class ViewHolder(private val itemBinding : CategoryBinding): RecyclerView.ViewHolder(itemBinding.root) {
		fun bind(item : Cate, position: Int){
			itemBinding.apply {
				tvName.text = item.name
				imageView.setImageResource(item.image)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(CategoryBinding.inflate(
			LayoutInflater.from(parent.context), parent, false)
		)
	}

	fun addItems(items: List<Cate>) {
		data.addAll(items)
		notifyDataSetChanged()
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(data[position], position)
	}

	override fun getItemCount(): Int {
		return data.size
	}
}