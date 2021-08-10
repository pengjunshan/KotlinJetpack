package com.example.kotlinjetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/14 17:16:16
 * @Describe: 数据库表
 */
@Entity(tableName = "student")
class Student (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "age")
    var age: Int?

    ) {
    constructor(id: Int) : this(id,"",0)
    constructor(id: String, i: Int) : this(null,id,i)
}