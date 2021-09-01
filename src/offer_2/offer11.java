package offer_2;

/**
 * @author wgl
 * @create 2021-09-01 21:00
 */
public class offer11 {
    public int minArray(int[] numbers) {
        return bs(numbers, 0, numbers.length - 1);
    }
    public int bs(int[] numbers, int left, int right) {
        int mid = left + (right - left)/2;
        if (numbers[mid] >= numbers[left] && numbers[mid] >= numbers[right]) {
            return bs(numbers, mid + 1, right);
        }
        if (numbers[mid] <= numbers[left] && numbers[mid] <= numbers[right]) {
            if (mid - 1 >= 0 && numbers[mid - 1] > numbers[mid]) {
                return numbers[mid];
            }
            return bs(numbers, left, mid - 1);
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        offer11 offer11 = new offer11();
        System.out.println(offer11.minArray(new int[]{1}));
    }
}
