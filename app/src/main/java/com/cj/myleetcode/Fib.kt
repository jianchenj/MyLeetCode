package com.cj.myleetcode

//https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
class Fib {
    fun fib(n: Int): Int {
        //         if (n <= 1) return n
        // val dp = IntArray(n + 1)
        // dp[0] = 0
        // dp[1] = 1
        // for (i in 2..n) {
        //     dp[i] = (dp[i - 1] + dp[i - 2])%1000000007
        // }
        // return  dp[n]
        if (n <= 1) return n
        var pre = 1
        var prepre = 0
        var resutlt = 0
        for (i in 2..n) {
            resutlt = (pre + prepre)%1000000007
            prepre = pre
            pre = resutlt
        }
        return resutlt
    }
}