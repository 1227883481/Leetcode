package offer;

/**
 * @author wgl
 * @create 2021-05-12 21:03
 */
public class offer017 {
    public static void main(String[] args) {
        offer017 offer017 = new offer017();
        System.out.println(offer017.movingCount(4, 4, 20));

    }
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res =
         1 + dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited);
        return res;
    }
}
