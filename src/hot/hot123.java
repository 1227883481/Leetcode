package hot;

/**
 * @author wgl
 * @create 2021-07-21 21:46
 */
class hot123 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left = left * nums[i - 1];
            res[i] = left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            res[i] = res[i] * right;
        }
        int i;
        return res;
    }
}
