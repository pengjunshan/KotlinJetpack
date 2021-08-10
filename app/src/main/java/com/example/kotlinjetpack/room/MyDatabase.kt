package com.example.kotlinjetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/14 17:17:17
 * @Describe:
 */

//后续的数据库升级是根据这个version来比较的，exportSchema导出架构
@Database(entities = [Student::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDBInstace(context: Context): MyDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "kotlinjetpack.db"
            )
                .allowMainThreadQueries()//允许在主线程查询
                .fallbackToDestructiveMigration()//升级异常处理
                .build()
    }

}