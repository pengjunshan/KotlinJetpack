package com.example.kotlinjetpack.kotlin

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/6/25 11:29:29
 * @Describe:初始化类
 */

fun main() {

    /**
     * 主构造函数使用临时变量
     */
//    var teacher = Teacher("何炅", 50)
//    println(teacher.name)//何炅
//    println(teacher.toString())//Teacher(name='何炅', age=50)
//
//    var teacher2 = Teacher2("黄磊", 52)
//    println(teacher2.name)//黄磊
//    println(teacher2.toString())//Teacher2(name='黄磊', age=52)
//
//    val teacher3 = Teacher3("黄晓明")//调用的是次构造函数
//    println(teacher3.toString())//Teacher3(name='黄晓明', age=18)
//
//    var teacher4 = Teacher4("马云", 20)
//    println(teacher4.toString())//Teacher4(name='马云', age=1)

    /**
     * 初始化块
     */
//    var teacher5 = Teacher5("小马云")
//    println(teacher5.toString())

    val teacher6 = Teacher6()
    teacher6.getName()

    val teacher7 = Teacher7()
    teacher7.getName()
    teacher7.getName()

}

/**
 * 主构造函数使用临时变量
 */
class Teacher(
    _name: String,
    _age: Int,
) {
    var name = _name
    var age = _age
    override fun toString(): String {
        return "Teacher(name='$name', age=$age)"
    }
}

/**
 * 主构造函数中直接定义属性变量
 */
class Teacher2(
    var name: String,
    var age: Int = 10,//可以设置默认值
) {
    override fun toString(): String {
        return "Teacher2(name='$name', age=$age)"
    }
}

/**
 * 次构造函数
 */
class Teacher3(
    var name: String,
    var age: Int,
) {
    //次构造函数 通过this指向把值传递给了主构造函数
    constructor(name: String) : this(name, 0) {
        //这里可以进行初始化代码逻辑
        this.age = 18
    }

    override fun toString(): String {
        return "Teacher3(name='$name', age=$age)"
    }
}

/**
 * 初始化块
 */
class Teacher4(
    var name: String,
    var age: Int,
) {
    init {
        println("${name} " + if (age > 18) "满18" else "未满18")
        age = if (age > 18) 1 else 0 //判断age的值 然后修改age的值
    }

    override fun toString(): String {
        return "Teacher4(name='$name', age=$age)"
    }
}

/**
 * 初始化顺序
 */
//1.主构造函数里声明的属性
//2.类级别的属性赋值
//3.init初始化块里的属性赋值和函数调用
//4.次构造函数里的属性赋值和函数调用
class Teacher5(
    var name: String,
    var age: Int,
) {
    var hight: Int = 175

    init {
        println("初始化块 ${name} " + if (age > 18) "满18" else "未满18")
    }

    constructor(name: String) : this(name, 10) {
        hight = 180
        println("这里是次构造函数")
    }

    override fun toString(): String {
        return "Teacher5(name='$name', age=$age, hight=$hight)"
    }

}

/**
 * 延迟初始化 只能用在var变量上
 * 该修饰只能用于类体中(不是在主构造函数中)声明的var属性，注意是var(可变属性)并且仅当该属性没有自定义getter或setter时，该属性必须是非空类型，并且不能是原生类型。
 */
class Teacher6 {
    lateinit var name: String

    init {
        name = "中国惊奇先生"
    }

    fun getName() {
        if (::name.isInitialized) println(name) else println("name为空")
    }
}

/**
 * 惰性初始化 只能用在val变量上
 *惰性初始化是一种常见的模式，直到第一次访问该属性的时候，才根据需要创建对象的一部分，当初始化过程消耗大量资源并且在使用对象时并不总是需要数据时，这个非常有用。
 * 而且再次调用属性的时候，只会得到结果，而不会再次执行lazy{}的运行过程
 */
class Teacher7 {
    val name: String by lazy {
        println("马上赋值")
        "镇魂街"
    }

    fun getName(){
        println(name)
    }
}
