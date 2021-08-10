package com.example.kotlinjetpack.lifecycle

import androidx.lifecycle.LifecycleService

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/1 18:25:25
 * @describe：
 */
class LifecycleService() : LifecycleService() {
    init {
        lifecycle.addObserver(LifecycleServiceObserver())
    }
}