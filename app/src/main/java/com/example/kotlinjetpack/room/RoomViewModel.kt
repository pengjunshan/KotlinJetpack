package com.example.kotlinjetpack.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/5/14 17:15:15
 * @Describe:
 */
class RoomViewModel(application: Application) : AndroidViewModel(application) {

    var studentDao: StudentDao

    private var index: Int = 0

    init {
        studentDao = MyDatabase.getDBInstace(application).getStudentDao()
    }


    // 获取全部集合
    fun getStudentList(): LiveData<List<Student>> {
        return studentDao.queryAllStudent()
    }

    // 添加
    fun mInsert() {
        index++
        studentDao.insertStudent(Student( "张无忌"+index, 18))
    }

    // 删除
    fun mDelete(id: Int) {
        studentDao.deleteStudent(Student(id))
    }

    // 修改
    fun mUpdate(student: Student) {
        studentDao.updateStudent(Student(student.id, student.name, 12))
    }

    // 清空数据
    fun mClaer() {
        studentDao.claerStudent()
    }


}