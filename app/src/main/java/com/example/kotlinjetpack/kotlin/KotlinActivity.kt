package com.example.kotlinjetpack.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlinjetpack.R

class KotlinActivity : AppCompatActivity() {

    var name: String? = null
    var love = "爱你"
    val age=18

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }

    fun click1(view: View) {
        Log.e("TAG", "name=" + name.toString())
        Log.e("TAG", "length=" + name?.length)
        Log.e("TAG", "love=" + love.length)
//        age = 20
    }
}