package algorithm;

public class 最长公共子序列 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {


        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        int text1Len = text1.length();
        int text2Len = text2.length();
        int[][] dp = new int[text1Len+1][text2Len+1];

        for (int i = 1; i <= text1Len; i++) {
            for (int j = 1; j <= text2Len; j++) {
                if (text1Arr[i-1] == text2Arr[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1Len ][text2Len ];
    }
}
