package com.example.kotlinjetpack.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinjetpack.R
import com.example.kotlinjetpack.databinding.ActivityViewbindingBinding

/**
 * @copyright：杭州柯林电气股份有限公司版权所有
 * @author: PengJunShan
 * @time：2021/4/1 9:17
 * @describe：ViewBinding使用
 * 通过视图绑定，系统会为模块中的每个 XML 布局文件生成一个绑定类，通过绑定类，我们可以直接操作控件id，而不需要findViewById,这样我们可以避免控件id无效出现的空指针问题。
 */
class ViewBindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewbindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewbindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = "芜湖大司马"
        binding.button5.setOnClickListener { showContent() }
    }

    fun showContent() {
        val s = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioButton -> "葫芦岛吴奇隆"
            R.id.radioButton2 -> "可爱冯提莫"
            else -> "杭州马霸霸"
        }
        binding.textView2.text = s
    }
}