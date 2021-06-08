package offer;

/**
 * @author wgl
 * @create 2021-06-01 22:53
 */
public class offer047 {
    public static void main(String[] args) {
        offer047 offer047 = new offer047();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(offer047.maxValue(grid));
    }
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] max = new int[m][n];
        int sum = 0;
        for(int i = 0; i < m; i++) {
            max[i][0] = grid[i][0] + sum;
        }
        sum = 0;
        for(int j = 0; j < n; j++) {
            max[0][j] = grid[0][j] + sum;

        }
        for(int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                max[x][y] = Math.max(max[x - 1][y], max[x][y - 1]) + grid[x][y];
            }
        }
        return max[m - 1][n - 1];
    }
}
