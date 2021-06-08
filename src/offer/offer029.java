package offer;

import java.util.Arrays;

/**
 * @author wgl
 * @create 2021-05-16 0:42
 */
public class offer029 {

    public static void main(String[] args) {
        offer029 offer029 = new offer029();
//        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] ints = {{1,2},{3,4}};
        System.out.println(Arrays.toString(offer029.spiralOrder(ints)));


    }
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int count = 0;
        int b = matrix.length;
        int a = matrix[0].length;
        int sum = a*b;
        int y = -1;
        int x = -1;
        int [] res = new int[a * b];
        while (count <= sum) {
            x++;
            y++;
            // if (a == 1 && b == 1) {
            //     res[count++] = matrix[y][x];
            //     res[count++] = matrix[y][x+1];
            //     res[count++] = matrix[y+1][x+1];
            //     res[count++] = matrix[y+1][x];

            // }
            if (a == 1) {
                for (int i = 0; i < b; i++) {
                    res[count++] = matrix[y][x];
                    y++;
                }
                break;
            }
            if (b == 1) {
                for (int i = 0; i < a; i++) {
                    res[count++] = matrix[y][x];
                    x++;
                }
                break;
            }
            for (int i = 0; i < a - 1; i++) {
                res[count++] = matrix[y][x];
                x++;
            }
            if (count > sum) break;
            for (int i = 0; i < b - 1; i++) {
                res[count++] = matrix[y][x];
                y++;
            }
            if (count > sum) break;
            for (int i = 0; i < a - 1; i++) {
                res[count++] = matrix[y][x];
                x--;
            }
            if (count > sum) break;
            for (int i = 0; i < b - 1; i++) {
                res[count++] = matrix[y][x];
                y--;
            }
            a = a - 2;
            b = b - 2;
        }
        return res;
    }
}
