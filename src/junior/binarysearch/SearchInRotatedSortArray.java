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
public class SearchInRotatedSortArray {

    public static void main(String[] args) {
        int[] test = new int[]{
                6,8,9,1,3,5
        };
       int index = search(test, 5);

    }
    /**
     * @param a: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public static int search(int[] a, int target) {
        if (null == a || a.length == 0){
            return -1;
        }
        int start = 0;
        int end = a.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (a[mid] == target){
                return mid;
            }

            if (a[start] < a[mid]){
                if (a[start] <= target && target < a[mid]){
                    end = mid;
                }else {
                    start = mid;
                }
            }else {
                if (a[mid] < target && target <= a[end]){
                    start = mid;
                }else {
                    end = mid;
                }

            }
        }

        if (a[end] == target){
            return end;
        }

        if (a[start] == target){
            return start;
        }
        return -1;
    }


}
