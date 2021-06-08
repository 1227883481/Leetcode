package study;

import java.util.Arrays;

/**
 * @author wgl
 * @create 2021-04-24 17:10
 */
public class returnTry {
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        returnTry returnTry = new returnTry();
        System.out.println(returnTry.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        for (int i = prices.length - 1; i > 0; i--) {
            prices[i] = prices[i] - prices[i - 1];
        }
        System.out.println(prices);
        System.out.println(Arrays.toString(prices));
        prices[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            prices[i] = prices[i - 1] + prices[i];
        }
        System.out.println(Arrays.toString(prices));
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = prices[i] - prices[j];
                if (max < k) {
                    max = k;
                }
            }
        }
        return max;

    }
}
