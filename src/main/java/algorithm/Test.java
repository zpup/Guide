package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {


        List<String> abc = new ArrayList<>();
        abc.add("1");
        abc.add("2");
        abc.add("1");
        abc.add("3");
        abc.add("4");
        abc.remove("1");
//        longestPalindrome("aba");
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
