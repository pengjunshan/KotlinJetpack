package com.example.kotlinjetpack.kotlin

/**
 * @Author: pengjunshan
 * @Date: 2021/10/12 4:03 下午
 * @Description: 枚举-接口-抽象类
 */
class `10EnumInterface` {
}
fun main(){
    //枚举类
    val type = MyEnum.NORTH
    when(type){
        MyEnum.NORTH->  println(666)
        MyEnum.SOUTH->  println(888)
        MyEnum.WEST -> println(999)
    }
}

/**
 * 枚举类
 */
enum class MyEnum{
    NORTH,
    SOUTH,
    WEST
}

//定义接口
interface OnItemClick{
    val name:String
    fun itemClick(index:Int)
}

//实现接口
class MAdapter(override val name: String) : OnItemClick{
    override fun itemClick(index: Int) {
    }
}

//定义抽象类
abstract class BaseClass{
    open fun initView(){}
    abstract fun initData()
}

//继承抽象类
class MyClass : BaseClass() {

    //重新initView函数
    override fun initView(){
    }

    //继承initData函数
    override fun initData() {
    }

}