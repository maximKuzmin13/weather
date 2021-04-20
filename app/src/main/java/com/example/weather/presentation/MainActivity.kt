package com.example.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.weather.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = supportFragmentManager.findFragmentById(R.id.fl_content) ?: RecyclerViewFragment()

        val mFragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        mFragmentTransaction.replace(R.id.fl_content, fragment).commit()
    }
}