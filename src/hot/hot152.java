package hot;

/**
 * @author wgl
 * @create 2021-06-21 21:57
 */
public class hot152 {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        int pos = 0;
        int nag = 0;
        int cur = 0;
        int posCur = 0;
        int nagCur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                cur = Math.max(pos * nums[i], nums[i]);
                pos = cur;
                nag = nag * nums[i];
            }
            if (nums[i] < 0) {
                posCur = nag * nums[i];
                nagCur = Math.min(pos * nums[i], nums[i]);
                cur = posCur;
                pos = posCur;
                nag = nagCur;
            }
            if (nums[i] == 0) {
                nag = 0;
                pos = 0;
            }
            if (cur > res) {
                res = cur;
            }
        }
        return res;
    }
}
