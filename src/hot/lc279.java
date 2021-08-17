package hot;

/**
 * @author wgl
 * @create 2021-08-16 16:30
 */
public class lc279 {
    public static void main(String[] args) {
        lc279 lc279 = new lc279();
        lc279.numSquares(12);
    }
    public int numSquares(int n) {
        int count = 1;
        for (; count < n; count++) {
            if (count * count > n) {
                break;
            }
        }
        count--;
        int[][] dp = new int[count + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 2; i <= count; i++) {
            for (int j = 1; j <= n; j++) {
                if (i * i > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - i*i]);
                }
            }
        }
        int mod = (int) (Math.pow(10, 9) + 7);
        return dp[count][n];
    }
}
