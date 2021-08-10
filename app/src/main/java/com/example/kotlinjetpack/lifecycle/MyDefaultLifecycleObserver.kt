package com.example.kotlinjetpack.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/1 19:24:24
 * @describe：观察者
 * 方式一：通过实现 DefaultLifecycleObserver 接口，然后重写自己业务需要监听的生命周期方法
 * 官方推荐使用方式，因为随着 Java8 的流行，注解可能会被废弃。
 */
class MyDefaultLifecycleObserver : DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.e("TAG","onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.e("TAG","onPause")
    }

}