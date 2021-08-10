package com.example.kotlinjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.kotlinjetpack.viewbinding.ViewBindingActivity

class MainActivity : AppCompatActivity() {

    private var sum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shRandom()
        var button3:Button = findViewById(R.id.button3)
        button3.setOnClickListener { shRandom() }
    }

    fun shRandom(){
        val random = random(50)
        var randomTV:TextView = findViewById(R.id.randomTV)
        randomTV.text = random.toString()
    }

    fun addClick(view: View) {
        sum++
        showNum(sum)
    }

    fun cutClick(view: View) {
        sum--
        showNum(sum)
    }

    private fun showNum(sum: Int) {
        var contentTV: TextView = findViewById(R.id.contentTV)
        contentTV.text = sum.toString()
    }

    private fun random(randomSum:Int): Int {
        return (1..randomSum).random()
    }

    fun toActivity(view:View){
        val intent = Intent(this,
            ViewBindingActivity::class.java)
        startActivity(intent)
    }
}