package junior.sumarrange;

/**
 * Random Pick with Weight
 * https://leetcode.cn/problems/random-pick-with-weight/
 * LeetCode 528
 *
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 *
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 *
 */
public class RandomPickWeight {
    private int[] sum;

    public RandomPickWeight(int[] w) {
        int n = w.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i-1] + w[i-1];
        }
    }

    public int pickIndex() {
        int len = sum.length;
        int random = (int)(Math.random() * sum[len - 1])  + 1;
        int left = 1, right = len - 1;
        while (left + 1 < right) {
            int mid = left + (left + right) / 2;
            if (sum[mid] > random) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (sum[right] == random) {
            return right;
        }
        return left;
    }
}
