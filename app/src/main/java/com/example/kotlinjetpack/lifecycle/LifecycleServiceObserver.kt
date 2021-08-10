package com.example.kotlinjetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/1 18:46:46
 * @describe：
 */
class LifecycleServiceObserver: LifecycleObserver {

    /**
     * 应用场景：比如播放音乐
     * 1.进入时：先执行寄主函数再执行观察者函数
     * 2.退出时：先执行观察者函数再执行寄主函数
     */

    //当寄主执行onCreate时调用
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create(){
        Log.e("TAG","create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy(){
        Log.e("TAG","destroy");
    }
}