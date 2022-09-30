package senior.recursion;

/**
 * 457 · 经典二分查找问题
 *
 * https://www.lintcode.com/course/43/learn/457?chapterId=291&sectionId=1693&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A43%22%7D&ac=false
 */
public class FindPosition {

    public int findPosition(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
       return findPosition(nums, 0, nums.length - 1, target);
    }

    private int findPosition(int[] nums, int start, int end, int target){
        if (start > end){
            return -1;
        }
        int mid = start + (end - start)/2;

        if (nums[mid] < target){
            return findPosition(nums, start , mid - 1, target);
        }
        if (nums[mid] > target){
            return findPosition(nums, mid + 1, end, target);
        }

        return mid;
    }
}
