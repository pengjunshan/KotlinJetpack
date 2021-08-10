package com.example.kotlinjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinjetpack.databinding.DatabindingActivity
import com.example.kotlinjetpack.databindingviewmodellivedata.DataViewLiveActivity
import com.example.kotlinjetpack.kotlin.KotlinActivity
import com.example.kotlinjetpack.lifecycle.LifecycleActivity
import com.example.kotlinjetpack.livedata.LiveDataActivity
import com.example.kotlinjetpack.room.RoomActivity
import com.example.kotlinjetpack.viewbinding.ViewBindingActivity
import com.example.kotlinjetpack.viewmodel.ViewModelActivity

/**
 * @copyright：杭州柯林电气股份有限公司版权所有
 * @author: PengJunShan
 * @time：2021/4/1 16:27
 * @describe：菜单页
 */
class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    // 跳转到Lifecycle
    fun toLifecycle(view: View) {
        startActivity(Intent(this, LifecycleActivity::class.java))
    }

    // 跳转到ViewBinding
    fun toViewBinding(view: View) {
        startActivity(Intent(this, ViewBindingActivity::class.java))
    }

    // 跳转到ViewModel
    fun toViewModel(view: View) {
        startActivity(Intent(this, ViewModelActivity::class.java))
    }

    // 跳转到LiveData
    fun toLiveData(view: View) {
        startActivity(Intent(this, LiveDataActivity::class.java))
    }

    // 跳转到DataBinding
    fun toDataBinding(view: View) {
        startActivity(Intent(this, DatabindingActivity::class.java))
    }

    // 跳转到DataBindingViewModelLiveData
    fun toDataBindingViewModelLiveData(view: View) {
        startActivity(Intent(this, DataViewLiveActivity::class.java))
    }

    // Room
    fun toRoomRecyclerView(view: View) {
        startActivity(Intent(this, RoomActivity::class.java))
    }

    fun toKotlin(view: View) {
        startActivity(Intent(this, KotlinActivity::class.java))
    }

}