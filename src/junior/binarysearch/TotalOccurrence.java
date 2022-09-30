package junior.binarysearch;

/**
 * 462 · 目标出现总和
 * https://www.lintcode.com/problem/462/?fromId=161&_from=collection
 *
 * 描述
 * 给一个升序的数组，以及一个target，找到它在数组中出现的次数。
 *
 */
public class TotalOccurrence {

    public static void main(String[] args) {
        int[] test = {
                1,1,1,1,1,1,1,1,1
        };

       int result =  totalOccurrence(test, -2);


    }
    /**
     * @param a: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public static int totalOccurrence(int[] a, int target) {
        if (null == a || a.length == 0){
            return 0;
        }
        int startIndex = findFirstIndex(a, target);
        int lastIndex = findLastIndex(a, target);
        if (startIndex == -1){
            return  0;
        }
        return lastIndex - startIndex + 1;
    }

    private static int findLastIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {//右边界比较纯粹，所以底下先判断 右边界， 所以是取 last.
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target){
            return start;
        }
        return -1;
    }

    private static int findFirstIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] < target){// 左边界比较纯粹， 所以底下先判断 左边界，所以取 first.
                start = mid;
            }else {
                end = mid;
            }
        }

        if (nums[start] == target){
            return start;
        }

        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}
