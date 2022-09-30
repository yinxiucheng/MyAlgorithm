package junior.binarysearch;

/**
 * 460 · 在排序数组中找最接近的K个数
 *
 * https://www.lintcode.com/problem/460/?fromId=161&_from=collection
 *
 */
public class KClosestNumbers {

    public static void main(String[] args) {
        int[] test = new int[]{
                1,4,6,8
        };
        int[] result = kClosestNumbers(test, 3, 3);
    }
    /**
     * @param a: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public static int[] kClosestNumbers(int[] a, int target, int k) {
        if (null == a || a.length == 0 || k == 0){
            return new int[]{};
        }
        int closeIndex = findClosestIndex(a, target);
        if (closeIndex == -1){
            return new int[]{};
        }

        //背向双指针从 closeIndex 往两边 走，left、right,边走边比较。
        int[] result = new int[k];
        result[0] = a[closeIndex];
        int left = closeIndex - 1;
        int right = closeIndex + 1;
        for (int i = 1; i < k; i++) {
            if (left >= 0 && right <= a.length - 1){
                if (target - a[left] <= a[right] - target){
                    result[i] = a[left--];
                }else {
                    result[i] = a[right++];
                }
            }else if (right <= a.length - 1){
                result[i] = a[right++];
            }else {
                result[i] = a[left--];
            }
        }
        return result;
    }

    //找到最接近 target值的 数 在 nums 数组的index。
    private static int findClosestIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        //谁最接近返回 谁的 Index。
        if (Math.abs(target - nums[start]) > Math.abs(target - nums[end])){
            return end;
        }else {
            return start;
        }
    }
}
