package com.wx.exercise.task

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.wx.exercise.bean.Person
import com.wx.exercise.common.Constants
import com.wx.exercise.source.local.db.PersonDatabase
import kotlinx.coroutines.coroutineScope

class PersonInfoWork (
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(Constants.PERSON_ASSETS_NAME).use { input ->
                JsonReader(input.reader()).use {reader ->
                    val type = object : TypeToken<List<Person>>(){}.type
                    val lovers : List<Person> = Gson().fromJson(reader, type)
                    val db = PersonDatabase.getInstance(applicationContext)
                    db.personDao().insertAll(lovers)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e("LoverInfoWork", "Error $ex")
            Result.failure()
        }
    }
}