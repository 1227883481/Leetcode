package labuladong;

/**
 * @author wgl
 * @create 2021-08-02 22:05
 */
public class lc05 {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int max = 1;
        String res = Character.toString(arr[0]);
        for(int center = 1; center < arr.length - 1; center++) {
            int i = 1, sum = 1;
            while (center - i >= 0 && center + i < arr.length) {
                if (arr[center - i] == arr[center + i]) {
                    sum = sum + 2;
                    if (sum > max) {
                        max = sum;
                        // res = new String(Arrays.copyOfRange(arr, center - i, center + i + 1));
                        res = s.substring(center - i, center + i + 1);
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        // int max2 = 2;
        for (int center = 0; center + 1 < arr.length; center++) {
            if (arr[center + 1] != arr[center]) {
                continue;
            }
            int i = 0, sum = 0;
            while (center - i >= 0 && center + 1 + i < arr.length) {
                if (arr[center - i] == arr[center + 1 + i]) {
                    sum = sum + 2;
                    if (sum > max) {
                        max = sum;
                        // res = new String(Arrays.copyOfRange(arr, center - i, center + 1 + i + 1));
                        res = s.substring(center - i, center + 1 + i + 1);
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}

