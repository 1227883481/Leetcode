package git;

/**
 * @author wgl
 * @create 2021-08-05 16:47
 */
public class MostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            int cur = Math.min(height[i], height[j]) * (j - i);
            if (cur > max) {
                max = cur;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
