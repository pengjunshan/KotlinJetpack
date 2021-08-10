package com.example.kotlinjetpack.kotlin

import android.util.Log

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/19 14:36:36
 * @Describe:  类型 变量 常量 函数
 */
class Variables {
}

fun main(args: Array<String>) {
    /**
     * 数据类型？
     * String
     * Char
     * Boolean
     * Number ->Byte Short Int Long Float Double
     * Array
     */

    /**
     * var: 变量定义关键字
     * num: 变量名
     * Int: 定义类型
     * =: 赋值运算符
     * 100: 赋值
     */
    var num: Int = 100

    /**
     * 可变变量var 可改变值
     * 只读变量val 只能赋值一次
     */
    var age: Int = 18
    val name: String = "甜心"
    age++ //可改变
//    name = "baby" // 报错 使用val定义的变量是不可改变的只能赋值一次
    println("age=" + age)
    println("name=" + name)

    /**
     * 类型推断：对于已声明并赋值的变量，它允许你省略类型定义
     */
    var love = "敲键盘" //自动推算类型为String

    /**
     * if表达式
     */
    // 方式一和java一样
    if (age > 18) {
        println("成年了")
    } else {
        println("未成年")
    }
    // 方式二 简写
    println(if (age > 18) "已经成年2" else "未成年2")

    /**
     * Range
     * Range是Kotlin相对Java新增的一种表达式，它表示的是值的范围，类似于数学中的区间。
     * Range的表达式是像这样子的：1..20，其中..是运算符，它表示一个闭区间[1, 20]。而右开区间用until表示：1 until 20，即[1, 20)
     */
    // 1.Range表达式一般是和in和!in操作符一起使用，表示是否包含在该区间内
    val a = 5

    if (a in 2..10) {//相当于 i >= 2 && i <= 20
        println("我在区间")
    }

    if (a !in 2..10) {//相当于 i < 2 && i > 20
        println("我不在区间")
    }

    // 2.对于一些整形的range（IntRange、LongRange、CharRange）是可以进行迭代的，它们可以和for循环一起使用
    for (i in 1..6) println(i)//输出123456

    // 3.使用downTo()函数可以对range进行倒序迭代
    for (i in 6 downTo 1) println(i)//输出654321

    // 4.使用step()函数，这里指定为2，则每次遍历后会以2个为单位遍历
    for (i in 8..16 step 2) println(i)//输出8 10 12 14 16

    /**
     * when使用
     */
    // 1.作为表达式使用,也可以将代码块作为我们的分支体，这时候代码块中最后一个表达式或者变量就是该分支体的返回结果
    var n = "小芳"
    var m = when (n) {
        "小明" -> "我是小明"
        "小芳" -> {
            println("lailai")
            "我是小芳芳"
        }
        "小强" -> "我是小强"
        else -> "未知人"
    }
    println(m)

    // 2.作为语句使用
    when (n) {
        "小明" -> println("我是小明2")
        "小芳" -> println("我是小芳2")
        "小强" -> {
            println("我是小强2")
        }
        else -> println("未知人2")
    }
    // 可以检测一个值在（in）或者不在（!in）一个区间或者集合中
    when (6) {
        in 1..10 -> {
            var n = 10
            println(n)
        }
        else -> print(66)
    }
    //检测一个值是（is）或者不是（!is）一个特定类型的值，可以直接使用类型的属性和方法
    var x = "love"
    when (x) {
        is String -> println("love长度= " + x.length)
        else -> false
    }
    // 无参使用
    when {
        x?.length==4 -> println("长度对的")
        else -> println("长度不对")
    }

    /**
     * 字符串模板
     * 模板支持在字符串的引号内放入变量值
     * 还支持字符串里计算表达式的值并插入结果，添加在${}中的任何表达式，都会作为字符串的一部分求值
     */
    val man = "沈腾"
    val woman ="贾玲"
    println("$man love $woman")

    val falg =false
    println("我爱的人是：${if (falg) "邓紫棋" else "张靓颖"}")

    setStudent("郑恺")
    setStudent("郑恺",38)
    setMotion(motion2="游泳",motion1 = "乒乓",motion3 = "爬山")
    println(`123`())
    println(`class`())

}

// 定义函数
private fun doSomething(age:Int,flag:Boolean) :String{
    return "运动"
}
//默认值参数
private fun setStudent(name:String,age:Int=18):Unit{
    println("名字：$name , 年龄：$age")
}
// 具名函数参数
private fun setMotion(motion1:String,motion2:String,motion3:String){
    println("运动1：$motion1 , 运动2：$motion2, 运动3：$motion3")
}
//反引号中的函数名
private fun `123`():Int{
    return 666
}
private fun `class`():String{
    return "class"
}