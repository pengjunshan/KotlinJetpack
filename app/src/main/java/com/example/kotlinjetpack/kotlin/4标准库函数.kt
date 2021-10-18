package com.example.kotlinjetpack.kotlin

import java.io.File

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/6/7 15:39:39
 * @Describe:标准库函数
 */
class `4StandardFun` {
}

fun main() {

    fun applyFun() {
        // 设置user对象 先创建一个user对象 然后通过对象名配置属性
        val user = User()
        user.age = 18
        user.name = "刘德华"
        println(user.toString())//年龄 18 名字 刘德华

        // 通过apply来隐式的配置属性 lamdba中对象引用是this
        val user2 = User().apply {
            age = 16
            name = "刘亦菲"
        }
        println(user2)//年龄 16 名字 刘亦菲
    }

    fun letFun() {

        // 通过let lamdba中对象引用是it
        val user = User().let {
            it.age = 12
            it.name = "张硕硕"
            it
        }
        println(user.toString())//年龄 12 名字 张硕硕
    }

    applyFun()
    letFun()

    fun isLong(name: String) = name.length > 10
    fun priStr(isLong: Boolean) {
        println(if (isLong) "1111" else "0000")
    }

    fun runFun() {
        //光看作用域行为，run和apply差不多，但与apply不同，run函数不返回接收者，run返回的是lambda结果，也就是true或 者false。
        val user = User()
        user.age = 12
        val run = user.run {
            age === 10
        }
        println(run)// false

        // run也可以执行函数引用
        "We are family".run(::isLong)//把字符串传过去接收一个布尔值
            .run(::priStr)// 把上一个run返回布尔值传过去
    }

    runFun()

    fun withFun() {
        //with函数的功能和run基本一样，唯一不同就是调用方式不同，with需要传入值参
        val user = User()
        val with = with(user) {
            age === 10
        }
        println(with)// false
    }
    withFun()

    //also函数和let函数功能基本一样，不同的是also返回的是接收者对象，而let返回的是lambda表达式最后一行，基于also返回接收者对象，我们可以通过also做基于原始对象的一些链式调用
    fun alsoFun() {
        val user = User().also {
            it.age = 10
        }.also {
            it.name = "鹿晗"
        }
        println(user.toString())// 年龄 10 名字 鹿晗
    }
    alsoFun()

    //takeIf函数根据lambda表达式内的条件语句给出的true或者false，如果是true就返回接收者对象，如果是false就返回null，功能来看和if语句类似，优点在于可以直接在对象实例调用，不需要再变量赋值
    fun takeIf() {
        val user = User()
        user.age = 10
        user.name = "张艺兴"
        val n = user.takeIf {
            it.age === 10
        }?.name
        println(n)// 张艺兴
    }
    takeIf()

    //takeUnless函数和takeIf函数辅助使用，takeUnless函数使lambda表达式里的条件语句返回false时返回接收对象。
    fun takeUnless(){
       val n = User().takeUnless {
            it.age===10
        }?.name
        println(n)//迪丽热巴
    }
    takeUnless()

}

class User {
    var age: Int = 0
    var name: String = "迪丽热巴"

    override fun toString(): String {
        return "年龄 $age 名字 $name"
    }
}