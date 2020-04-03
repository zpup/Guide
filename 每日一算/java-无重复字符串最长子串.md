####### java-无重复字符串最长子串



偷偷的引用下leetcode的一个图片 

![avatar](https://pic.leetcode-cn.com/2847c2d9fb9a6326fecfcf8831ed1450046f1e10967cde9d8681c42393d745ff-frame_00001.png)

```
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

```

```java

//解题方法：1 暴力解题 递归循环 2 游标窗口计算路径差 滑动窗口
import java.util.HashMap;
import java.lang.Math;
import java.util.Map;

/**
 * 解题思路
 * 设定 返回值 最大值 max
 * 发生重复的位置 i 例 abcdb  i 记录 ab 中b的位置
 * 循环角标 j
 * map 记录循环过的值
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int i = 0;
        int len = s.length();
        for (int j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                //此处 比较例子 "abba" i 需要取大的值 其实就是区间选择问题
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //取大的max
            max = Math.max(max, j - i + 1);
            //记录了当前的数据 增加了内存存储
            map.put(s.charAt(j), j + 1);
        }

        return max;

    }
}

```

