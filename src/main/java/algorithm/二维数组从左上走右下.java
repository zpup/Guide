package algorithm;

public class 二维数组从左上走右下 {


    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    /*
     * 最小成本
     * 输入参数为二维数组，m行，n列
     * */
    private static int minCost(int cost[][], int m, int n) {
        int i, j;
        /*
         * 开辟一个dp数组，数组有m+1行；n+1列
         * dp[m][n]表示
         */

        int dp[][] = new int[m + 1][n + 1];

        dp[0][0] = cost[0][0];

        /* Initialize first column of total cost(dp) array */
        for (i = 1; i <= m; i++)
            dp[i][0] = dp[i - 1][0] + cost[i][0];

        /* Initialize first row of dp array */
        for (j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] + cost[0][j];

        /* Construct rest of the dp array */

        for (i = 1; i <= m; i++){
            for (j = 1; j <= n; j++){
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
            }
        }


        return dp[m][n];
    }


    public static void main(String args[]) {
        int cost[][] = {
                {1, 2, 3},
                {4, 4, 2},
                {1, 5, 3}
        };
        System.out.println("达到矩阵右下角" + " (2, 2) 的最小成本 = " + minCost(cost, 2, 2));

    }
}


