package com.example.kotlinjetpack.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/1 19:50:50
 * @describe：监听整个 app 的生命周期，官方文档推荐使用 ProcessLifecycleOwner。
 * 同样可以使用继承或注解两种方式。代码和普通继承或注解两种方式代码一模一样。
 * 在 Application 中，使用 ProcessLifecycleOwner 添加此观察者
 */
class MyProcessLifecycleOwner : DefaultLifecycleObserver {

    /**
     * 在应用程序的整个生命周期中只会被调用一次
     */

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.e("TAG","onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.e("TAG","onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.e("TAG","onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.e("TAG","onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.e("TAG","onStop")
    }


    /**
     * 永远不会被调用，系统不会分发调用 onDestroy 事件
     */
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.e("TAG","onDestroy")
    }
}