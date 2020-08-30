package com.wx.exercise.source.local.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wx.exercise.bean.Person
import com.wx.exercise.common.Constants

@Dao
interface PersonDao {
    @Query("SELECT * FROM ${Constants.PERSON_TABLE_NAME}")
    fun getPersons() : PagingSource<Int, Person>

    @Query("SELECT * FROM  ${Constants.PERSON_TABLE_NAME} WHERE id = :id")
    fun getPerson(id : String): LiveData<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(lovers : List<Person>)
}