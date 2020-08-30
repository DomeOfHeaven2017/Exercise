package com.wx.exercise.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wx.exercise.common.Constants

@Entity(tableName = Constants.PERSON_TABLE_NAME)
data class Person(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    val Introduction: String,
    val another_name: String,
    val article: String,
    val birth: String,
    val college: String,
    val cover: String,
    val flag: String,
    val height: String,
    val name: String,
    val nationality: String,
    val place: String,
    val profession: String,
    val weight: String
) {
    override fun toString(): String = "{ $name - $nationality }"
}