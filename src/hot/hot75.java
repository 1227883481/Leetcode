package hot;

/**
 * @author wgl
 * @create 2021-06-18 11:47
 */
public class hot75 {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int i1 = -1, i2 = nums.length;
        for (int i = 0; i < nums.length && i < i2;) {
            if (nums[i] == 0) {
                swap(nums, i, ++i1);
                i++;
            } else if (nums[i] == 1){
                i++;
                continue;
            } else {
                swap(nums, i, --i2);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
