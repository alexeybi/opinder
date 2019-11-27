package com.example.opinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.opinder.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


//        setContentView(R.layout.activity_main)
    }
}
