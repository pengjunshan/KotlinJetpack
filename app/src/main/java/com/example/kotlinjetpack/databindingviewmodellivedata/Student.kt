package com.example.kotlinjetpack.databindingviewmodellivedata

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/4/20 10:35:35
 * @Describe:
 */
class Student constructor(var age: Int, var name: String?) {

    override fun toString(): String {
        return "Student(name=$name, age=$age)"
    }

}