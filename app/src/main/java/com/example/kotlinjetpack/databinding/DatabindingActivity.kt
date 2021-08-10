package com.example.kotlinjetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.kotlinjetpack.R

/**
 * @copyright：杭州柯林电气股份有限公司版权所有
 * @author: PengJunShan
 * @time：2021/4/8 14:04
 * @describe：
 */
class DatabindingActivity : AppCompatActivity() {
    private var userBean = UserBean()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityDatabindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_databinding)
//        binding.lifecycleOwner = this
        userBean.live.set("爱运动")
        userBean.name.set("刘翔")
        binding.user = userBean
        binding.button11.setOnClickListener {
            userBean.live.set("爱学习")
            Log.e("TAG","name="+userBean.name.get())
        }

        /**
         * ViewBinding：
        仅仅支持绑定 View
        不需要在布局文件中添加 layout 标签
        需要在模块级 build.gradle 文件中添加 viewBinding = true 即可使用
        效率高于 DataBinding，因为避免了与数据绑定相关的开销和性能问题
        相比于 kotlin-android-extensions 插件避免了空异常

        DataBinding：
        包含了 ViewBinding 所有的功能
        需要在模块级 build.gradle 文件内添加 dataBinding = true 并且需要在布局文件中添加 layout 标签才可以使用
        支持 data 和 view 双向绑定
        效率低于 ViewBinding，因为注释处理器会影响数据绑定的构建时间
         */
    }
}