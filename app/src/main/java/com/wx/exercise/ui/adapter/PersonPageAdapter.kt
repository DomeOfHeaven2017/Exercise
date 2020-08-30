package com.wx.exercise.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wx.exercise.R
import com.wx.exercise.bean.Person

class PersonPageAdapter : PagingDataAdapter<Person, PersonPageHolder>(DIFF_CALLBACK){

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Person>() {
            override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: PersonPageHolder, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonPageHolder =
        PersonPageHolder(parent)
}

class PersonPageHolder (parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.layout_item_person_list, parent, false)
){
    private val infoText: AppCompatTextView = itemView.findViewById(R.id.tv_info_person_list_item)
    private val coverImg: AppCompatImageView = itemView.findViewById(R.id.img_cover_person_list_item)

    fun bindTo(person: Person) {
        infoText.text = person.name
        with(person.cover) {
            if (isNotEmpty()) {
                coverImg.load(this) {

                }
            }
        }
    }
}