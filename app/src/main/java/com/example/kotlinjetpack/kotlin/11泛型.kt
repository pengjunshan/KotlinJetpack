package com.example.kotlinjetpack.kotlin

import com.example.kotlinjetpack.R

/**
 * @Author: pengjunshan
 * @Date: 2021/10/13 5:09 下午
 * @Description: 泛型
 */
class `11泛型` {
}

fun main(){

    // 定义泛型
    val box1:GenericityBox<Gen> = GenericityBox(Gen("小明",10))
    val box2:GenericityBox<Cup> = GenericityBox(Cup("小芳"))

    // 泛型函数
    val box3:GenericityBox<Gen> = GenericityBox(Gen("小明",12))
    val box4:GenericityBox<Cup> = GenericityBox(Cup("小芳"))

    box3.getT()?.run {
        println("box3=$name")
    }
    box4.able = true
    box4.getT()?.run {
        println("box4=$name")
    }

    //多泛型参数
    val box5:GenericityBox<Gen> = GenericityBox(Gen("小明",16))
    box5.able = true
    val cup = box5.getTR {
        Cup(it.name)
    }
    println("cup=${cup?.name}")

    //泛型类型约束
    val box6:GenericityBox2<Gen> = GenericityBox2(Gen("小鹏",18))
//    val b:GenericityBox2<Cup> 报错 泛型指定为Gen
    println("box6=${box6.getName()}")

    //vararg关键字
    val box7:GenericityBox3<Gen> = GenericityBox3(Gen("小张",10),Gen("小六",12))
    println("box7=${box7.getT(1)}")

    //[]操作符取值
    val box8:GenericityBox4<Gen> = GenericityBox4(Gen("小张",10),Gen("小六",12))
    println("box8=${box8[0]}")

    //out in


}

/**
 * 定义泛型
 */
class GenericityBox<T>(item:T){
    var able = false
    private var mSub:T = item

    fun getT(): T? {
        return mSub.takeIf { able }
    }

    fun <R> getTR(subi:(T)->R): R ?{
        return subi(mSub).takeIf { able }
    }
}

data class Gen(var name:String,var age:Int)
class Cup(val name:String)

/**
 * 泛型类型约束
 */
class GenericityBox2<T:Gen>(item:T){
    private var mSub:T = item
    fun getName():String{
        return mSub.name
    }
}

/**
 * vararg关键字
 */
class GenericityBox3<T:Gen>(vararg item : T){
    var able = false
    var mSub: Array<out T> = item

    fun getT(index:Int):T{
        return mSub[index]
    }
}

/**
 * []操作符获取
 */
class GenericityBox4<T:Gen>(vararg item : T){
    var mSub: Array<out T> = item

    operator fun get(index: Int) :T{
        return mSub[index]
    }
}

