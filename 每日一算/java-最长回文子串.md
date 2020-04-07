# 最长回文子串

#### leetcode 中题


```java

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划
```

先看题：官方给了 关键字 动态规划。那其实我们最优思路应该是这个方向
我这边 是想到了 对称解法 
示例 "aba" "abba"
面对字符串我们肯定是循环的
思路就是 找到 字符串判断两边是不是一样的。

题解是leetcode 官方解
```java
class Solution {
    public static String longestPalindrome(String s) {
        //过滤空
        if (s == null || s.length() < 1) return "";
        //这个是为了记录 截取下标
        int start = 0, end = 0;
        //循环 
        for (int i = 0; i < s.length(); i++) {
            //这个是处理 aba 这种情况
            int len1 = expandAroundCenter(s, i, i);
            // 这个是处理 abba 这种情况
            int len2 = expandAroundCenter(s, i, i + 1);
            //比较大小是为了处理最长
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //换算下标
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //截取
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        //防止越界
        //判断是否相等
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--; //左移
            R++; //右移
        }
        return R - L - 1;
    }
}
```