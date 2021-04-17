package com.yogenp.codingtest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yogenp.codingtest.R
import dagger.hilt.android.AndroidEntryPoint

/*
* Host activity for fragments
* */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}