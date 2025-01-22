package com.example.durymong

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.durymong.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.fragment_settings_edit_user_info)
    }
}