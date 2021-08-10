package com.example.kotlinjetpack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kotlinjetpack.R

/**
 * @Author: pengjunshan
 * @Date: 2021/7/26 5:35 下午
 * @Description: 类作用描述
 */
class MyAndroidViewModel(application: Application) : AndroidViewModel(application) {
    private val mApplication: Application

    init {
        this.mApplication = application
    }
}