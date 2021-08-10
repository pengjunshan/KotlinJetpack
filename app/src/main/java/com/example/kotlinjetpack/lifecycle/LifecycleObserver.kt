package com.example.kotlinjetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/1 16:32:32
 * @describe：生命周期观察者
 * 方式二：通过注解
 */
class LifecycleObserver : LifecycleObserver {

    /**
     * 应用场景：比如播放视屏、定位功能
     * 1.进入时：先执行寄主函数再执行观察者函数
     * 2.退出时：先执行观察者函数再执行寄主函数
     */

    //在寄主执行onResume时调用
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        Log.e("TAG","resume");
    }

    //在寄主执行onPause时调用
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause(){
        Log.e("TAG", "pause")
    }
}