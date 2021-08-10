package com.example.kotlinjetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/7 14:27:27
 * @describe：
 */
class LiveDataViewModel : ViewModel() {

    var mNumber: MutableLiveData<Int> = MutableLiveData()

    init {
        mNumber.value = 0
    }

    fun addNumber() {
//        mNumber.value = mNumber.value?.plus(1)
        mNumber.value = mNumber.value?.inc()
    }

    override fun onCleared() {
        super.onCleared()
        mNumber.value = 0
    }

}