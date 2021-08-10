package com.example.kotlinjetpack.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/2 14:01:01
 * @describe：监听到所有的 Activity 的所有生命周期
 * 而原来的写法有两个问题，第一，你必须得继承 BaseActivity 才能具备管理当前 Activity 的功能。这又涉及到合作开发，不想继承，或者忘记继承。第二，让 BaseActivity 承担了过多的职责，并不符合基本的设计原则。
 */
class MyActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    private var mList = arrayListOf<Activity>()

    override fun onActivityPaused(p0: Activity) {

    }

    override fun onActivityStarted(p0: Activity) {
    }

    override fun onActivityDestroyed(p0: Activity) {
        mList.remove(p0)
        Log.e("TAG","集合-="+mList.size)
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
    }

    override fun onActivityStopped(p0: Activity) {
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        mList.add(p0)
        Log.e("TAG","集合+="+mList.size)
    }

    override fun onActivityResumed(p0: Activity) {

    }
}