package study;

/**
 * @author wgl
 * @create 2021-04-25 21:23
 */
public class numsOfOne {

    public static void main(String[] args) {
        numsOfOne numsOfOne = new numsOfOne();
//        System.out.println(numsOfOne.hammingWeight(0b11111111111111111111111111111101));
        System.out.println(String.valueOf(0b11111111111111111111111111111101));
    }
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
