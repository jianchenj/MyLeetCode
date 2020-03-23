package com.cj.myleetcode

/*
*
*  https://leetcode-cn.com/problems/longest-palindromic-substring/
*
*  5 最长回文串



 $len = strlen($s);
        if($len < 2) return $s;         //初始化判断
        $dp = [];                       //初始化动态规划dp数组，dp[i][j]表示从j到i的字符串是否为回文串
        $right = $left = 0;             //初始化最长的最优节点
        for($i=0;$i<$len;++$i){
            $dp[$i][$i] = true;         //只有一个元素的时候肯定为true
            for($j=$i-1;$j>=0;--$j){    //遍历到第i个元素，再倒退判断是否为回文串
                //头i尾j两个元素相等，且dp[i-1][j+1]是回文串，即dp[i][j]也是回文串
                //特殊情况,“bb”,此时dp[i-1][j+1]=dp[j][i]此时数组不成立，不存在截取的反向字符串
                $dp[$i][$j] = $s[$i] == $s[$j] && ($i-$j==1 || $dp[$i-1][$j+1]);
                if($dp[$i][$j] && ($i-$j)>($right-$left)){
                    $right = $i;        //截取的字符串的长度大于之前求得的左右长度，则取的左右下标点
                    $left = $j;
                }
            }
        }
        return substr($s,$left,$right-$left+1); //截取字符串



* */
class LeetCode5 {
//    fun longestPalindrome(s: String): String {
//        val len = s.length
//        if (len < 2) return s
//        var right = 0
//        var left = 0
//
//        for(i in  0 until len) {
//
//        }
//    }


}