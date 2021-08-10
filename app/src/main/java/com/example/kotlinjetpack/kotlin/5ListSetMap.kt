package com.example.kotlinjetpack.kotlin

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/6/11 10:48:48
 * @Describe:
 */
class ListSetMap {
}

fun main() {
    /**
     * list
     */
    //1.创建list集合 不可变集合
    val mList: List<String> = listOf("HTML", "VUE", "Kotlin", "JAVA")
    //get(index) 通过下标获取元素，如果下标越界会报错
    println(mList.get(2))//Kotlin
//    println(mList.get(4))//报错下标越界 java.lang.ArrayIndexOutOfBoundsException: 4
    // getOrEIse获取元素
    println(mList.getOrElse(4) { "notfind" })//notfind
    //getOrNull
    println(mList.getOrNull(4))// null
    println(mList.getOrNull(4) ?: "notfind")//notfind

    //2.可变集合
    //创建可变集合
    val mutableList: MutableList<String> = mutableListOf("HTML", "VUE", "Kotlin", "JAVA")
    //增加元素和移除元素
    mutableList.add(0, "Android")//在哪个下标插入
//    mutableList.add("Android")//在最后插入
    println(mutableList)//[Android, HTML, VUE, Kotlin, JAVA]
//    mutableList.remove("VUE")//根据元素移除
    mutableList.removeAt(1)//根据下标移除
    println(mutableList)//[Android, VUE, Kotlin, JAVA]
    //只读集合和可变集合互换
    val toMutableList = listOf<String>("HTML", "VUE", "Kotlin", "JAVA").toMutableList()
    toMutableList.add("Android")
    println(toMutableList)//[HTML, VUE, Kotlin, JAVA, Android]
    val toList = mutableListOf<String>("HTML", "VUE", "Kotlin", "JAVA").toList()
//    toList.add()//没有add方法
    println(toList)//[HTML, VUE, Kotlin, JAVA]

    //3.mutator函数
    //添加元素运算符与删除元素运算符
    val mutableList2: MutableList<String> = mutableListOf("HTML", "VUE", "Kotlin", "JAVA")
    mutableList2 += "Android"//添加元素
    println(mutableList2)// [HTML, VUE, Kotlin, JAVA, Android]
    mutableList2 -= "Android"//移除元素
    println(mutableList2)// [HTML, VUE, Kotlin, JAVA]
    // 基于lambda表达式指定的条件删除元素
    mutableList2.removeIf {
        it.contains("VUE")
    }
    println(mutableList2)//[HTML, Kotlin, JAVA]

    //4.集合遍历
    //for in 遍历
    val list: List<String> = listOf("HTML", "VUE", "Kotlin", "JAVA")
    for (item in list) {
        println(item)
    }
    //  forEach 遍历
    list.forEach {
        println(it + "-")
    }

    //forEachIndex 遍历时要获取索引
    list.forEachIndexed { index, item ->
        println("index=${index} item=${item}")
    }

    //5.解构 通过_符号过滤不想要的元素
    val (html: String, vue: String, _: String, java: String) = list
    println("${html} ${vue} ${java}")//HTML VUE JAVA

    /**
     * Set
     */
    //1.Set创建和获取元素
    //使用setof创建不可变集合
    val set: Set<String> = setOf("HTML", "VUE", "Kotlin", "JAVA")
    //获取元素elementAt() 和list获取元素类似
    println(set.elementAt(1))//正常获取元素
//    println(set.elementAt(4))//下标越界 报错java.lang.IndexOutOfBoundsException
    println(set.elementAtOrElse(4) { "nofind" })//如果找不到走lambder表达式
    println(set.elementAtOrNull(4) ?: "isNULL")//如果找不到返回Null

    //2.Set可变集合
    //通过MutableSetOf创建Set可变集合
    val mutableSet: MutableSet<String> = mutableSetOf("HTML", "VUE", "Kotlin", "JAVA")
    //增加元素和移除元素 set集合中不会存在相同的元素
    mutableSet.add("JS")//新增
    mutableSet.remove("VUE")//移除
    mutableSet += "Android"//新增
    mutableSet += "Kotlin"//集合中已有Kotlin就不会加进去了
    mutableSet -= "HTML"//移除
    println(mutableSet)

    //3.集合转换
    val toMutableSet = set.toMutableSet()//转可变集合
    toMutableSet += "Android"
    println(toMutableList)
    val toSet = mutableSet.toSet()//转不可变集合
    println(toSet)

    //list集合转set集合
    val toSet1 = list.toSet()
    val toMutableSet1 = list.toMutableSet()
    //set集合转list集合
    val toList1 = set.toList()
    val toMutableList1 = set.toMutableList()

    /**
     * Map
     */
    //1.map的创建
    //to看上去像关键字，但事实上，它是个省略了点号和参数的特殊函数，to函数将它左边和右边的值转化成一对Pair 。
    val map: Map<String, Int> = mapOf("马云" to 20, "马化腾" to 18, "黄征" to 22)
    val mapOf = mapOf<String, Int>(Pair("托马斯", 2), Pair("拜登", 3))
    println(map)//{马云=20, 马化腾=18, 黄征=22}
    println(mapOf)//{托马斯=2, 拜登=3}
    //2.获取元素
    //[key]根据key获取值，读取键对应的值，如果键不存在就返回null
    println(map["马化腾"])//18
    //getValue(key) 根据key获取值，如果键不存在就抛出异常
    println(map.getValue("马云"))//20
    //getOrElse，读取键对应的值，或者使用匿名函数返回默认值
    println(map.getOrElse("马赛克") { "unknown" })//unknown
    //getOrDefault，读取键对应的值，或者返回默认值
    println(map.getOrDefault("马赛克", 0))//0

    //3.可变MutableMap
    val mutableMap: MutableMap<String, Int> = mutableMapOf("马云" to 20, "马化腾" to 18, "黄征" to 22)
    mutableMap += "刘强东" to 19
    mutableMap.put("黄晓明", 6)
    mutableMap -= "马化腾"
    mutableMap.remove("马云")
    println(mutableMap)//{黄征=22, 刘强东=19, 黄晓明=6}
    //4.getOrPut(key){n} 如果获取的Key没有，就先添加再返回，否则返回相应的值
    println(mutableMap.getOrPut("老王") { 1 })//因为没有老王 就先添加到map中
    println(mutableMap)//{黄征=22, 刘强东=19, 黄晓明=6, 老王=1}
    //5.遍历
    //forEach 返回it
    mutableMap.forEach {
        println(it)
    }
    //forEach 返回key value值
    mutableMap.forEach { key, value ->
        println("${key} ${value}")
    }
    //for in返回key value值
    for ((key, value) in mutableMap) {
        println("${key} ${value}")
    }

}