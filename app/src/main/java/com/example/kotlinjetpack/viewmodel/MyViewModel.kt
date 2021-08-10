package com.example.kotlinjetpack.viewmodel

import androidx.lifecycle.ViewModel

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/6 9:51:51
 * @describe：
 */
class MyViewModelv : ViewModel() {
     var mNumber = 0

//    fun getNumber():Int{
//        return this.mNumber
//    }
//
//    fun setNumber(number:Int){
//        this.mNumber = number
//    }

    /**
     * 与之相关的Activity被销毁时，该方法会被系统调用。我们可以在该方法中执行一些资源释放的相关操作
     */
    override fun onCleared() {
        super.onCleared()
    }

}