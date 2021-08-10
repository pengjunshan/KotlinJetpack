package com.example.kotlinjetpack.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinjetpack.R

/**
 * @copyright：杭州柯林电气股份有限公司版权所有
 * @author: PengJunShan
 * @time：2021/4/1 15:53
 * @describe：Lifvcycle使用
 */
class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        //方式一
        lifecycle.addObserver(MyDefaultLifecycleObserver())
        //方式二
        lifecycle.addObserver(LifecycleObserver())
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause()")
    }

    fun startService(view: View) {
        startService(Intent(this,LifecycleService::class.java))
    }
    fun stopService(view: View) {
        stopService(Intent(this,LifecycleService::class.java))
    }
}