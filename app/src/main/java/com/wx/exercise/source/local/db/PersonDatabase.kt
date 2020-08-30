package com.wx.exercise.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.wx.exercise.bean.Person
import com.wx.exercise.common.Constants
import com.wx.exercise.task.PersonInfoWork

@Database(entities = [Person::class], version = Constants.DATABASE_VERSION)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    companion object{
        @Volatile private var instance :  PersonDatabase? = null

        fun getInstance(context: Context) : PersonDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) : PersonDatabase {
            return Room.databaseBuilder(context, PersonDatabase::class.java, Constants.DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<PersonInfoWork>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }).build()
        }
    }
}