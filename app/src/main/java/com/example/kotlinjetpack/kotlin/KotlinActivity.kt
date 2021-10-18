package com.example.kotlinjetpack.kotlin

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinjetpack.R
import com.huantansheng.easyphotos.EasyPhotos
import com.huantansheng.easyphotos.utils.permission.PermissionUtil

class KotlinActivity : AppCompatActivity() {

    var name: String? = null
    var love = "爱你"
    val age=18

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        if (PermissionUtil.checkAndRequestPermissionsInActivity(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
        ) {
            EasyPhotos.preLoad(this)
        }
    }

    fun click1(view: View) {
        Log.e("TAG", "name=" + name.toString())
        Log.e("TAG", "length=" + name?.length)
        Log.e("TAG", "love=" + love.length)
//        age = 20
    }

    fun click2(view: View) {
        EasyPhotos.createCamera(this, true)
            .setFileProviderAuthority("com.huantansheng.easyphotos.demo.fileprovider")
            .start(101) //也可以选择链式调用写法
    }
}