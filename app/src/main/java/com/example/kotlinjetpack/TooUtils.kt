package com.example.kotlinjetpack

/**
 * @Copyright: 杭州柯林电气股份有限公司版权所有
 * @Author: PengJunShan
 * @Date: 2021/4/20 13:53:53
 * @Describe:
 */
object TooUtils {
    fun toString(i: Int): String? {
        return i.toString() + ""
    }

    fun isEmpty(string: String?): Boolean {
        return string != null && string.length == 0
    }
    fun isWeakEmpty(string: String): Boolean {
        return isEmpty(string) && string.trim { it <= ' ' }.length == 0
    }
}