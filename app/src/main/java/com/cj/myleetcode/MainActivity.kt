package com.cj.myleetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        @JvmStatic
        fun main(arg: Array<String>) {
//            val lruCache = LRUCache(2)
//            println(lruCache.put(1, 1))
//            println(lruCache.put(2, 2))
//            println(lruCache.get(1))
//            println(lruCache.put(3, 3))
//            println(lruCache.get(2))
//            println(lruCache.put(4, 4))
//            println(lruCache.get(1))
//            println(lruCache.get(3))
//            println(lruCache.get(4))
//            println(lruCache)
            val l = LeetCode3()
            l.lengthOfLongestSubstring("pwwkew")
        }
    }

}
