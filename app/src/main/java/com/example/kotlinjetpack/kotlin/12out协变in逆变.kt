package com.example.kotlinjetpack.kotlin

/**
 * @Author: pengjunshan
 * @Date: 2021/10/16 8:39 下午
 * @Description: 类作用描述
 */
class `out-in` {
}

// 协变
interface OnProductionOut<out T>{
    fun onOut():T
}

// 逆变
interface OnConsumerIn<in T>{
    fun onIn(item:T)
}

// 即是协变又是逆变
interface ProductionOutIn<T>{
    fun onOut():T
    fun onIn(item:T)
}

// 1.定义三个类 食物 快餐 汉堡
open class Food
open class FastFood:Food()
class Burger:FastFood()

// 2.定义三个生产食物的类分别实现OnProductionOut类
class FoodOut:OnProductionOut<Food>{
    override fun onOut(): Food {
        println("FoodOut")
        return Food()
    }
}
class FastFoodOut:OnProductionOut<FastFood>{
    override fun onOut(): FastFood {
        println("FastFoodOut")
        return FastFood()
    }
}
class BurgerOut:OnProductionOut<Burger>{
    override fun onOut(): Burger {
        println("BurgerOut")
        return Burger()
    }
}

class FoodIn:OnConsumerIn<Food>{
    override fun onIn(item: Food) {
        println("FoodIn")
    }
}

class FastFoodIn :OnConsumerIn<FastFood> {
    override fun onIn(item: FastFood) {
        println("FastFoodIn")
    }
}

class BurgerIn:OnConsumerIn<Burger> {
    override fun onIn(item: Burger) {
        println("BurgerIn")
    }
}

fun main(){

    //子类泛型对象可以赋值给父类泛型对象，用out。
    val mProduction1 : OnProductionOut<Food> = FoodOut()
    val mProduction2 : OnProductionOut<Food> = FastFoodOut()
    val mProduction3 : OnProductionOut<Food> = BurgerOut()
    mProduction1.onOut()

    //父类泛型对象可以赋值给子类泛型对象，用in。
    val mConsumer1 : OnConsumerIn<Burger> = FoodIn()
    val mConsumer2 : OnConsumerIn<Burger> = FastFoodIn()
    val mConsumer3 : OnConsumerIn<Burger> = BurgerIn()
    mConsumer1.onIn(Burger())

}
