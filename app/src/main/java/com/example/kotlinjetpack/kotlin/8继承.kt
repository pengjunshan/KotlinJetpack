package com.example.kotlinjetpack.kotlin

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/6/29 14:11:11
 * @Describe:继承
 */
class `8OpenClass` {
}

fun main() {
    val cat = Cat()
    println(cat.name)//小狗
    cat.getName()//this2 is 小狗

    /**
     * 类型检测
     */
    val cat2 = Cat()
    println(cat2 is Cat)//true
    println(cat2 is Animal)//true

    /**
     * 类型转换
     */
    println(cat2 as Animal)
    var c = cat as Animal
//    var c1 = cat2 as Animal2//报错 java.lang.ClassCastException
    var c1 = cat2 as? Animal2//为了避免抛出异常，可以使用安全转换操作符 as?，它可以在失败时返回 null
    println(c1)
    c?.getName()//this2 is 小狗

    /**
     * Any类
     * 无须在代码里显示指定，每一-个类都会继承一个共同的叫作Any的超类。
     */
    println(cat is Any)// true
    println(cat as Any)// com.example.kotlinjetpack.kotlin.Cat@66d3c617
    println(Any().javaClass)//class java.lang.Object 编译器最终会把Any编译成java中的Object类
}

/**
 * 继承
 * 类默认都是封闭的，要让某个类开放继承，必须使用open关键字修饰它。
 * 父类的函数也要以open关键字修饰，子类才能覆盖它。
 */
open class Animal(var name: String) {
    //父类的函数也要以open关键字修饰，子类才能覆盖它。
    open fun getName() {
        println("this is ${name} ")
    }
}

class Cat : Animal("小狗") {
    override fun getName() {
//        super.getName()
        println("this2 is ${name} ")
    }
}



open class Animal2() {}
