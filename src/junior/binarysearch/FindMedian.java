package junior.binarysearch;
/**
 * 931 · K 个有序数组的中位数
 *
 * https://www.lintcode.com/problem/931/
 *
 * 描述
 * 有 k 个有序数组 nums。找到这 k 个有序数组的中位数。
 *
 * 给出的数组长度不一定相等。
 * 给出的数组中的元素均为正整数。
 * 如果数组中没有元素则返回 0。
 * 为了保证时间复杂度，程序会被重复执行多遍
 *
 */
public class FindMedian {

    public static void main(String[] args) {
        int[][] nums = {{1}, {2}, {3}};
        double result = findMedian(nums);
        System.out.print("the result is:" + result);
    }

    public static double findMedian(int[][] nums) {
        int n = getTotalSize(nums);
        if (n == 0){
            return 0;
        }
        if (n % 2 != 0) {
            return findKth(nums, n / 2 + 1);
        }
        return findKth(nums, n / 2) / 2.0 + findKth(nums, n / 2 + 1) / 2.0;
    }

    private static double findKth(int[][] nums, int k){
        int start = 0;
        int end = Integer.MAX_VALUE;

        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (getGTE(nums, mid) >= k){ // 二维数组里 大于 等于 mid 的值 多于 K了，
                start = mid;
            }else { //第一次mid 很大，getGTE(nums, mid) 可能等于0. 所以继续缩小右边界到较小值。
                end = mid;
            }
        }
        if (getGTE(nums, end) == k){
            return end;
        }
        return start;
    }

    //二维数组里比 大于等于 val 值的个数。
    private static int getGTE(int[][] nums, int val){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += getGTE(nums[i], val);
        }
        return sum;
    }

    // int[] nums 中 大于等于 val的值的个数。
    private static int getGTE(int[] nums, int val){
        if (null == nums || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (nums[mid] >= val){ //寻找第一个 等于 val的点 （left, right）, 切右边，第一个left == val , 或者right == val. 先找left,再找 right。
                right = mid;
            }else {
                left = mid;
            }
        }

        if (nums[left] >= val){
            return nums.length - left;
        }
        if (nums[right] >= val){
            return nums.length - right;
        }
        return 0;
    }


    private static int getTotalSize(int[][] nums){
        if (null == nums || nums.length == 0){
            return 0;
        }
        if (nums[0] == null || nums[0].length == 0){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i].length;
        }
        return total;
    }


}
