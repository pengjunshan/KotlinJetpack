package com.example.kotlinjetpack.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/14 17:16:16
 * @Describe:
 */
@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("SELECT * FROM student")
    fun queryAllStudent(): LiveData<List<Student>>

    //编译报错
//    @Query("SELECT * FROM student WHERE id=:id")
//    fun queryIdStudent(id: Int)

    @Query("DELETE FROM student")
    fun claerStudent()

}