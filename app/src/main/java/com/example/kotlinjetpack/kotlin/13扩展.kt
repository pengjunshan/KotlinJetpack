package com.example.kotlinjetpack.kotlin

/**
 * @Author: pengjunshan
 * @Date: 2021/10/15 11:10 上午
 * @Description: 类作用描述
 */
class `12扩展` {
}

fun main() {

    // 使用扩展函数
//    println("小明".addS("HHHHHH"))
//    "郭襄".easyPrint()
//    6666.easyPrint()

//    "杨过".easyPrint2().addS("爱小龙女").easyPrint()

    // 扩展属性
//    "asdfgzxc".numV.easyPrint()

    // 可空类扩展
    var name:String? = null
    name.setName("小笼包")
    name setName "贾玲"

}

/**
 * 定义扩展函数
 */
// 给字符串后面添加内容
fun String.addS(s: String) = this + s

// 给Any类添加一个函数
fun Any.easyPrint() = println(this)

// 泛型扩展函数 打印之后再把当前对象返回给调用者
fun <T> T.easyPrint2(): T {
    println(this)
    return this
}

//扩展属性
val String.numV
    get() = count { "abc".contains(it) }

// 可空类扩展
infix fun String?.setName(d:String) = println(this ?: d)
