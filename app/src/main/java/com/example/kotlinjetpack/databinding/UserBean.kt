package com.example.kotlinjetpack.databinding

import androidx.databinding.ObservableField

/**
 * 版权：杭州柯林电气股份有限公司版权所有
 * @author PengJunShan
 * @time： 2021/4/8 11:23:23
 * @describe：
 */
class UserBean {
    var live = ObservableField<String>()
    var name = ObservableField<String>()
}