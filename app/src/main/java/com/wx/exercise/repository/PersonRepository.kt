package com.wx.exercise.repository

import com.wx.exercise.source.local.db.PersonDao

class PersonRepository private constructor(private val personDao: PersonDao) {

    fun getPersons() = personDao.getPersons()

    fun getPerson(id : String) = personDao.getPerson(id)

    companion object {
        @Volatile private var instance: PersonRepository? = null

        fun getInstance(personDao: PersonDao) =
            instance?: synchronized(this) {
                instance ?: PersonRepository(personDao).also { instance = it }
            }
    }
}