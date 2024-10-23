package com.wangwh.demo.sdk_kext

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wangwh.demo.sdk_kext.databinding.ActivityMainBinding
import com.wangwh.sdk.kext.dp2px

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contentTv.text = "100dp = ${100.dp2px}px"
    }
}