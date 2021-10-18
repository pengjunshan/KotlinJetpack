package com.example.kotlinjetpack.kotlin

import kotlin.math.absoluteValue

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/6/24 9:29:29
 * @Describe:定义类
 */
class CreatClass {
}

fun main() {
    /**
     * field使用
     */
    var student = Student()

    student.name = " 老王  "//估计前后写空格
    println(student.name)//打印老王 没有空格

    println(student.age)
    student.age = -6
    println(student.age)//打印 是正6 因为自定义get中取绝对值了

    fun getAdder() {
        //如果adder不为空才会打印
        student?.adder?.also {
            println("地址=${it}")
        }
    }
    getAdder()

    println(student.value)//返回1-10的随机数

}

class Student {

    var name = "小明"
        get() = field.capitalize()
        set(value) {
            field = value.trim()//自定义set去除空格
        }
    var age = -12
        //自定义get和set函数，实际根据自己需求来自定义get和set
        get() = field.absoluteValue//自定义取绝对值
        set(value) {
            field = value.absoluteValue
        }

    var adder: String? = "杭州"

    var value: Int? = null
        get() = (1..10).random()//自定义返回值get不使用field
}