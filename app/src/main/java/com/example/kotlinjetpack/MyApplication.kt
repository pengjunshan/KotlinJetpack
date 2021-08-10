package com.example.kotlinjetpack

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.kotlinjetpack.lifecycle.MyActivityLifecycleCallbacks
import com.example.kotlinjetpack.lifecycle.MyProcessLifecycleOwner

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/1 19:54:54
 * @describe：
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyProcessLifecycleOwner())
        registerActivityLifecycleCallbacks(MyActivityLifecycleCallbacks())
    }
}