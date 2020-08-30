package com.wx.exercise.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.wx.exercise.R
import com.wx.exercise.repository.PersonRepository
import com.wx.exercise.source.local.db.PersonDatabase
import com.wx.exercise.ui.adapter.PersonPageAdapter
import com.wx.exercise.viewmodel.PersonListFactory
import com.wx.exercise.viewmodel.PersonViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PersonListFragment : Fragment() {

    private lateinit var mToolbar: Toolbar
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: PersonPageAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person_list, container, false)
        initView(view)
        initData()
        return view
    }

    private fun initView(view: View) {
        mToolbar = view.findViewById(R.id.toolbar_person_list_fragment)
        mRecyclerView = view.findViewById(R.id.recycler_person_list_fragment)
        mRecyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        mAdapter = PersonPageAdapter()
        mRecyclerView.adapter = mAdapter
    }

    private fun initData() {
        val viewModel by viewModels<PersonViewModel> {
            PersonListFactory(PersonRepository.getInstance(PersonDatabase.getInstance(requireContext().applicationContext).personDao()), this)
        }

        lifecycleScope.launch {
            viewModel.persons.collectLatest {
                mAdapter.submitData(it)
            }
        }
    }
}