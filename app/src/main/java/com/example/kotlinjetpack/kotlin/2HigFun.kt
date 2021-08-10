package com.example.kotlinjetpack.kotlin

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/27 10:02:02
 * @Describe: 高阶函数
 */
class HigFun {
}

fun main() {
    /**
     * 匿名函数
     */
    // {}是匿名函数  ()是调用匿名函数可以传值 匿名函数不支持参数默认值和具名函数参数。
    println({ a: Int, b: String ->
        "Welcome to HangZhou, $a!(copyright $b)"
    }(2021, "磐石"))

    var totalNum: Int = "missyous".count { letter ->
        letter == 's'
    }
    println("共有s个数=：" + totalNum)

    /**
     * 函数类型与隐式返回
     * 匿名函数也有类型，匿名函数可以当做变量赋值给函数类型变量，和其它变量一样，匿名函数就可以在代码里传递了。
     * 函数类型由传入的参数和返回值类型决定。
     */
    val nowFun: () -> String//定义一个函数nowFun返回类型是String
    nowFun = {
        val name = "西塘河"
        "你好 $name"
    }
    // 简写
    val nowFun2: () -> String = {
        val name = "西塘河2"
        "你好 $name"
    }
    println(nowFun())// 打印 “你好 西塘河”
    println(nowFun2())// 打印 “你好 西塘河”

    /**
     * 匿名函数参数
     * 参数的类型放在匿名函数的类型定义中，参数名则放在函数定义中
     */
    //可以带参数
    val paramFun: (String, Int) -> String = { name, age ->
        "你好 $name 年龄 $age"
    }
    println(paramFun("马云", 50))// 打印 “你好 马云 年龄 50”

    /**
     *  it关键值
     * 定义只有一个参数匿名函数时，可以使用it关键字当做参数名，当参数大于1个时it就不能用了。
     */
    val oneParamFun: (String) -> String = {
        "我喜欢：$it"
    }
    println(oneParamFun("林忆莲"))// 打印 “我喜欢：林忆莲”

    /**
     * 类型推断
     * 定义一个函数变量时，如果已经把匿名函数赋值给了变量，就不用指定变量类型里了。
     * 有参数时，匿名函数的参数名和类型都必须有
     */
    //省略前
//    val typeFun:()->String = {
//        "我喜欢："
//    }
    //省略后
    val typeFun = {
        "我喜欢："
    }
    println(typeFun())

    //省略前
//    val typeParamFun:(String,String)->String = { name, yarn ->
//        "Happy $name $yarn"
//    }
    //省略后
    val typeParamFun = { name: String, yarn: String ->
        "Happy $name $yarn"
    }
    println(typeParamFun("彭彭", "2025"))

    /**
     * 定义的参数是函数
     */
    val setTime = { goodName: String, yarn: Int ->
        "$yarn 天猫双十一 $goodName"
    }

    fun showTime(name: String, showGood: (String, Int) -> String) {
        val yarn = (2020..2030).shuffled().last()
        println(showGood(name, yarn))
    }

    showTime(name = "关晓彤", setTime)

    /**
     * 简略写法
     * 如果一个函数的lambda参数排在最后或者是唯一的参数，那么括住lambda值的圆括号就可以省略掉了。
     */

    showTime(name = "容祖儿") { goodName: String, yarn: Int ->
        "$yarn 天猫双十一 $goodName"
    }

    /**
     * 函数引用
     * 上面讲过了 把函数当成参数传给一个函数使用，不光可以传递匿名函数也可以传递具名函数的引用，只要可以使用lambda表达式地方都可以使用函数引用。
     */
    fun setStudent(name: String, age: Int): String {
        return "我是六年级的 $name 今年 $age 岁了"
    }

    fun setClass(name: String, student: (String, Int) -> String) {
        println(student(name, 12))
    }
    setClass("黄晓明", ::setStudent)//打印 “我是六年级的 黄晓明 今年 12 岁了”

    /**
     * 函数类型作为返回类型
     * 一个函数的返回值可以使一个函数（包括匿名函数和具名函数）。
     */
    fun getFruit(): (String) -> String {
        val currYarn = 2021
        return { fruitName: String ->
            "$currYarn 我喜欢吃 $fruitName"
        }
    }

    val fruit = getFruit()//返回的是个匿名函数
    println(fruit("樱桃"))// 打印 “2021 我喜欢吃 樱桃”

    /**
     * lambda与匿名内部类
     * 为什么要在代码中使用函数类型？函数类型能让开发者少写模式化代码，写出更灵活的代码。
     * Java8支持lambda表达式，但不支持将函数作为参数传递给另一个函数或者变量，不过Java的替代方案是匿名函数。
     * 下面对比下lambda和匿名内部类
     */
    // lambda表达式
    //定义一个函数最后一个参数是lamdba匿名函数
    fun setPhone(phoneName: String, moneyDeta: (String, Int) -> Unit) {
        val money = if (phoneName == "iphone12") 5800 else 6000
        moneyDeta(phoneName, money)
    }
    // 调用函数传入一个lamdba匿名函数
    setPhone("iphone12") { phoneName: String, money: Int ->
        println("$phoneName 价格为 $money")
    }

}