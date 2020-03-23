package com.cj.myleetcode

import kotlin.math.max

/*
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。


输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

解题思路，滑动窗口
 */
class LeetCode3 {

    /*
    pwwkew
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val length = s.length
        var i = 0
        var j = 0
        var result = 0
        val map: HashMap<Char, Int> = HashMap()//以char为key，保存出现该char的位置
        while (j < length) {
            if (map.containsKey(s[j])) {//发现重复，将窗口左边移到改位置
                i = max(map[s[j]]!!, i)
            }
            result = max(result, j - i + 1)//取较长的答案
            map[s[j]] = j + 1
            j++
        }
        return result

//        val n = s.length
//        var ans = 0
//        val map = HashMap<Char, Int>()//以char为key， int为char出现的位置
//        //滑动窗口为[i, j]
//        var i = 0
//        var j = 0
//        while (j < n) {
//            if (map.containsKey(s[j])) {//发现重复
//                i = max(map[s[j]]!!, i)//窗口左边移到这个重复的char的位置
//            }
//            ans = max(ans, j - i + 1)
//            map[s[j]] = j + 1
//            j++//窗口右边继续向右
//        }
//        return ans
    }
}