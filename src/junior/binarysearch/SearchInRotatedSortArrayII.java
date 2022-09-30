package junior.binarysearch;

/**
 * 62 · 搜索旋转排序数组
 *
 * https://www.lintcode.com/problem/62/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个有序数组，但是数组以某个元素作为支点进行了旋转(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
 * 给定一个目标值target进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。你可以假设数组中不存在重复的元素。
 *
 * 数组 = [4, 5, 1, 2, 3]
 * target = 1
 *
 */
public class SearchInRotatedSortArrayII {

    /**
     * @param a: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public  int search(int[] a, int target) {
        if (null == a || a.length == 0){
            return -1;
        }
        int midIndex = findMin(a);//找到最小值所在的 index.
        int start = 0;
        int end = a.length - 1;

        if (a[midIndex] == target){
            return midIndex;
        }

        if (a[midIndex] < target && target <= a[end])
            return binarySearch(a, midIndex, end, target);
        else return binarySearch(a, start, midIndex, target);
    }

    private int findMin(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            //保留有拐点的一边。 拐点就是最小值。
            if (nums[mid] > nums[end]){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]){
            return start;
        }
        return end;
    }

    private int binarySearch(int[] nums, int start, int end,  int target){
        if (start > end){
            return -1;
        }
        if (start == end){
            if (nums[start] == target) {
               return start;
            }
        }
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] > target){
                end = mid;
            }else {
                start = mid;
            }
        }

        if (nums[end] == target){
            return end;
        }

        if (nums[start] == target){
            return start;
        }
        return -1;
    }
}
