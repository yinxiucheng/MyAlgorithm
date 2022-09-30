package junior.binarysearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 1536 · 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://www.lintcode.com/problem/1536/description
 *
 */
public class SearchFirstLastIndex {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(7);
        array.add(7);
        array.add(8);
        array.add(8);
        array.add(10);

        List<Integer> result = searchRange(array, 8);

    }
    /**
     * @param a: the array of integers
     * @param target:
     * @return: the starting and ending position
     */
    public static List<Integer> searchRange(List<Integer> a, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == a || a.size() == 0){
            result.add(-1);
            result.add(-1);
            return result;
        }
        int index = binarySearch(a, target, true);
        result.add(index);
        if (index != -1){
            result.add(binarySearch(a, target, false));
        }else {
            result.add(-1);
        }
        return result;

    }


    private static int binarySearch(List<Integer> nums, int target, boolean leftIndex){
        int left = 0;
        int right = nums.size() - 1;

        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (target == nums.get(mid)){
                if (leftIndex){
                    right = mid;
                }else{
                    left = mid;
                }
            }else if (target > nums.get(mid)){
                left = mid;
            }else {
                right = mid;
            }
        }

        if (leftIndex){
            if (target == nums.get(left)){
                return left;
            }else if (target == nums.get(right)){
                return right;
            }else {
                return -1;
            }
        }else{

            if (target == nums.get(right)){
                return right;
            }else if (target == nums.get(left)){
                return left;
            }else{
                return -1;
            }
        }
    }


}
