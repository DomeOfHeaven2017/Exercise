package com.wx.exercise.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.wx.exercise.repository.PersonRepository

class PersonViewModel internal constructor(
    repository: PersonRepository,
    handler: SavedStateHandle
) : ViewModel() {

    val persons = Pager(
        PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            maxSize = 100
        )
    ) {
        repository.getPersons()
    }.flow

}