package com.example.kotlinjetpack.kotlin

import java.lang.Exception
import kotlin.math.roundToInt

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/28 10:46:46
 * @Describe: null安全  字符串操作  类型转换
 */
class NullSafe {
}

fun main() {
    /**
     * 非空类型
     * 对于null值问题，Kotlin反其道而行之，除非另有规定，变量不可为null值，这样一来运行时崩溃从根源上得到了解决。
     */
    var nullNmae = "打死你个Null"//默认情况下不可以为空
//    nullNmae = null//报错

    /**
     * 可空类型
     * 为了避免空指针异常，kotlin的做法是不让我们给非空类型变量赋null值，但null在Kotlin中依然存在。在类型后面加上？表示此变量可为null。
     */
    var mailName: String?//可以设置为空
    mailName = null
    println(mailName)//打印 null

    /**
     * null安全 ？操作符
     * 当调用一个可空变量的属性或方法，此变量可能为null，存在安全性，编译器会报红提示安全性问题，可通过？操作符解决。
     * ？使用修饰申明在成员变量的类型后面，表示这个变量可以为null。该变量如果为null时，不会执行该变量后面的逻辑，也不会抛出空指针异常，俗称空安全。如果不为null，会正常执行该变量后面的内容。
     */
    var womanName: String? = "aaa"
//    println(womanName.length)//报错 安全提示
    println(womanName?.length)//打印 3

    /**
     * le操作符
     * 当需要定义一个变量在一个特定的作用域时，可以考虑使用 let 函数。当然，更多的是用于避免 Null 判断。
     * 在 let 函数内部，用 it 指代调用 let 函数的对象
     */
    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls) {
        item?.let { println(it) } // 输出 Kotlin 并忽略 null
    }

    /**
     * !!感叹号操作符
     * !!加载变量后面，如果变量为null时会抛出空指针异常，像java语法一样空指针不安全；如果不为null，继续执行后面的代码。
     */
    var mName: String? = "xiaoming"
    println(mName!!.length)

    /**
     * ?:操作符elvis
     * 如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式（仅当左侧为空时，才会对右侧表达式求值
     */
    var b: String? = "abc"
    b = null
    val l = b?.length ?: -1
    println(l)//打印 -1

    /**
     * if判断
     * 和java语法一样，使用If判断变量活对象是否为null
     */
    var d: String? = "dddddd"
    println(if (d != null) d.length else -1)// 打印 6

    /**
     * filterNotNull()
     * 如果你有一个可空类型元素的集合，并且想要过滤非空元素，你可以使用 filterNotNull 来实现
     */
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    println(intList)// 打印 “[1, 2, 4]”

    /**
     * 异常
     * Kotlin 的异常和 Java 的一样， try…catch…finally代码块处理异常，唯一一点不同是：Kotlin 的异常都是 Unchecked exceptions。
     */
    // 检查抛出异常
    fun checkNull(number: Int?) {
        number ?: throw MyException()
    }

    var number: Int? = null
    try {
        checkNull(number)
        number!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    /**
     * 先决条件函数
     */
    // 检查抛出异常
    try {
        checkNotNull(number,
            { "checkNotNull is null" })//java.lang.IllegalStateException: checkNotNull is null
        number!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    /**
     * substring
     * 字符串截取，substring函数包前不包后，支持IntRange类型 (上篇文章讲过此用法),until创建的范围不包括上限值。
     */
    val str = "Hello My Friend"
    val index = str.indexOf('o')
    println(str.substring(0, index))//Hell
    println(str.substring(0 until index))//Hell
    println(str.substring(0..index))//Hello

    /**
     * split
     * split函数返回的是List集合数据，List集合又支持解构语法特性， 它允许你在- -个表达式里给多个变量赋值，解构常用来简化变量的赋值。
     */
    val str2 = "千玺,王源,俊凯"
    val list = str2.split(",")
    println(list)//打印 [千玺, 王源, 俊凯]
    var (name1, name2, name3) = str2.split(",")
    println("$name1 $name2 $name3")//打印 千玺 王源 俊凯
//    var (name1,name2,name3,name4)= str2.split(",") 因为数组中只有三个元素，如果解构赋值写了四个会报错下标越界IndexOutOfBoundsException

    /**
     * replace
     * Kotlin中的字符串替换方法
     * String.replace(oldValue: String, newValue: String, ignoreCase: Boolean = false): String
     * ignoreCase = true区分大小写
     */
    val str3 = "Hello My Friend haha"
    println(str3.replace('h', 'G'))//Hello My Friend GaGa
    println(str3.replace('h', 'G', ignoreCase = true))//Gello My Friend GaGa
    // 第一个参数是正则表达式，决定哪些要替换哪些字符
    // 第二个参数是匿名函数，处理要替换的字符
    var s = str3.replace(Regex("[Hyda]")) {
        when (it.value) {
            "H" -> "1"
            "y" -> "2"
            "a" -> "3"
            else -> "4"
        }
    }
    println(s)//1ello M2 Frien4 h3h3

    /**
     * 字符串比较
     */
    var s1 = "Hello"
    var s2 = "hello".capitalize()//修改了s2值
    println("$s1 $s2")//Hello Hello
    println(s1 == s2)//true
    println(s1 === s2)//false

    /**
     * forEach
     */
    "Hello My Friend".forEach {
        println(it)//H e l l o  M y  F r i e n d
    }
    /**
     * 类型检测 is 运算符
     * is运算符相当于java中的 instanceof
     */
    println("name" is String)// true
    println("name" !is String) // fasle
    println(666 is Number) // true
    println(666 !is Number) // false

    /**
     * as运算符
     * as运算符用于执行引用类型的显示类型转换，如果类型与指定类型相符，就会转换成功，如果类型不兼容，使用as?就会返回null
     */
    val ani = Ani()
    val dog = Dog()
    println(dog as Ani)
    var a: Ani? = dog as? Ani
    println(a)

    /**
     * 类型自动转换
     * 在java中判断出某个变量是什么类型后，想要使用其属性和方法时需要先强转其类型后才能调用其属性活方法
     * 在kotlin中知道变量是什么类型后，无需强转其类型，直接可以调用其属性或方法
     */
    var n = "abc"
    println(n.length)

    /**
     * 安全转换
     * Kotlin提供了toDoubleOrNull和tolntOrNull这样的安全转换函数，如果数值不能正确转换，与其触发异常不如干脆返回nul|值。
     */

    println("100".toInt())
    println("100.66".toDouble())
//    println("6.66".toInt()) 报错 java.lang.NumberFormatException: For input string: "6.66"
    println("6.66".toIntOrNull())// null

    /**
     * double转int
     */
    println(6.6666.toInt())// 精度损失 6
    println(6.6666.roundToInt())// 四舍五入 7

    /**
     * double类型格式化
     */
    val format = "%.2f".format(8.6666)
    println(format)//8.67


}

// 自定义异常
class MyException() : IllegalArgumentException("我是自定义异常")

open class Ani {
}

class Dog : Ani() {
}