package com.example.kotlinjetpack.kotlin

import java.text.SimpleDateFormat
import java.util.*

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/7/1 10:13:13
 * @Describe:对象使用
 */
class `9ObjectClass` {
}

fun main() {
    /**
     * Object关键字
     * 使用object关键字，你可以定义一个只能产生一个实例的类-单例
     * 使用object关键字有三种方式：对象声明、对象表达式、半生对象
     */
    //对象声明
//    println(Tools.getDate())//和java中调用static方法一样
//    println(Tools.getDate())//再次调用 不会执行init初始化代码块

    /**
     * 对象表达式
     * 有时候你不一定非要定义一个新的命名类不可，也许你需要某个现有类的一种变体实例，但只需用- -次就行了，事实上，对于这种用完就丢的类实例，连命名都可以省了。
     * 这个对象表达式是XX的子类，这个匿名类依然遵循object关键字的-一个规则，即一旦实例化，该匿名类只能有唯- - -个实例存在。
     */
    /**
     * 通过对象表达式生成一个类
     */
    val s = object : Stu() {
        override fun getName() = "杨过和小龙女"
        fun getAge():Int{
            return 18
        }
    }
    //和使用对象声明一样使用s类直接调用其函数
//    println("我的名字：${s.getName()}")//我的名字：杨过和小龙女
//    println("我的年龄：${s.getAge()}")//我的年龄：18

    // 伴生对象
    Associated()// 初始化第一次
    println("--------------------------")
    Associated()// 初始化第二次

    //嵌套类
    Nesting().getName("外部类调")
    Nesting.InerNesting().getName("内部类调")

    // 数据data类 默认toString方法
    println(classStudent("小明",19))//classStudent(name=小明, age=19)
    println(classStudent("小明",19)===classStudent("小明",19))

    // copy类 使用
    val copy1 = classCopy("小明")
    val copy2 = copy1.copy("baby")
    println(copy1)
    println(copy2)

    // 解构声明
    var (n,a) =classCopy("小明",18)
    println("name:${n} age:${a}")

}

/**
 * 对象声明：使用object定义类，相当于java中的单例模式，有利于组织代码、管理状态
 */
object Tools {
    init {
        println("init初始化")//因为是单例模式，多次调用只会执行一次
    }

    fun getDate(): String {
        return return SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())
    }
}

/**
 * 对象表达式 定义一个可继承的类
 */
open class Stu {
    open fun getName() = "神雕侠侣"
}

/**
 * 伴生对象
 * 如果你想将某个对象的初始化和一一个类实例捆绑在一起，可以考虑使用伴生对象，使用companion修饰符，
 * 你可以在一个类定义里声明一个伴生对象，一个类里只能有一个伴生对象；无论初始化多少次类，伴生对象只会初次的时候执行一次。
 */
class Associated{

    //无论初始化多少次类，伴生对象只会初次的时候执行一次。
    companion object{
        val  LOAN_TYPE = "loanType"
       init {
           println("我是伴生对象初始化了")
       }
    }

    // 类的init代码块，每初始化一次类时都会执行
    init {
        println("我是Associated对象初始化了")
    }

    fun getName(){
        println(LOAN_TYPE)
    }
}
/**
 * 嵌套类，和java使用一样
 * 如果一个类只对另一个类有用，那么将其嵌入到该类中并使这两个类保持在一起是合乎逻辑的，可以使用嵌套类。
 */
class Nesting{
    class InerNesting{
        fun getName(name:String){
            println("我是嵌套类 ${name}")
        }
    }
    fun getName(name:String){
        InerNesting().getName(name)
    }
}


/**
 * 数据类
 * 数据类,是专门设计用来存储数据的类，数据类提供了toString的个性化实现，==符号默认情况下，比较对象就是比较它们的引用值，数据类提供了equals和hashCode的个性化实现
 */
data class classStudent(var name:String,var age:Int)

/**
 * copy类
 */
data class classCopy(var name:String,var age:Int){
    constructor(name:String):this(name,18){
    }
}

/**
 * 解构声明
 */
data class decosClass(var name:String,var age:Int){
}
