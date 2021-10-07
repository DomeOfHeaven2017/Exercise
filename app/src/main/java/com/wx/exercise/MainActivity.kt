package com.wx.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wx.exercise.expand.ExpandRecyclerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ExpandRecyclerFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_activity_main, fragment)
            .commit()
    }
}