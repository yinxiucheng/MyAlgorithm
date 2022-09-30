package senior.binarysearch;

/**
 * 617 · 子数组的最大平均值 II
 *
 * https://www.lintcode.com/problem/617/?fromId=178&_from=collection
 *
 * 描述
 * 给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。
 *
 */
public class MaxAverage {

    public double maxAverage(int[] nums, int k) {
        // write your code here
        double start, end, mid;
        start = end = nums[0];
        for (int i = 0; i < nums.length; i++) {
            start = Math.min(start, nums[i]);
            end = Math.max(end, nums[i]);
        }

        while (start + 1e-5 < end){
            mid = (start + end)/2.0;
            if (canFind(nums, k, mid)){
                start = mid;
            }else {
                end = mid;
            }
        }
        return start;
    }

    //double maxAverage 需要用 double类型。

    /**
     *
     * @param A
     * @param K
     * @param maxAverage
     * @return
     *
     * (A[left] + A[left + 1] + ...+ A[right])/(right - left + 1) >= T
     * (A[left] + A[left + 1] + ...+ A[right]) >= T + ... + T (有 right - left + 1 个)
     * A[left] - T + A[left + 1] - T + ... + A[right] - T >= 0
     */
    private boolean canFind(int[] A, int K, double maxAverage){
        // 保持一个 K长度的窗口，然后 rightSum - 左边的minLeftSum.
        double rightSum = 0, leftSum = 0, minLeftSum = 0;
        for (int i = 0; i < K; i++) {
            rightSum += A[i] - maxAverage;
        }

        for (int i = K; i <= A.length; i++) { // 前缀和，rightSum 需要加 n + 1次。
            if (rightSum - minLeftSum >= 0){
                return true;
            }
            if (i < A.length){//这里需要判断一下，不然 有可能 加了 n+ 2次了。
                rightSum += A[i] - maxAverage;
                leftSum += A[i - K] - maxAverage;
                minLeftSum = Math.min(leftSum, minLeftSum);
            }
        }
        return false;
    }
}
