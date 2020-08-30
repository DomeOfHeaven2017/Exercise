package com.wx.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wx.exercise.ui.fragment.PersonListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_activity_main, PersonListFragment())
            .commit()
    }
}