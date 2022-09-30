package junior.binarysearch;

import java.util.*;

/**
 * 547 · 两数组的交集
 *
 * 描述
 * 给出两个数组，写出一个方法求出它们的交集
 *
 */
public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {5,0,0,6,1,6,2,2,4};
        int[] result = intersection(nums1, nums2);

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] result = new int[set.size()];
        int count = 0;
        for (int item: set) {
            result[count++] = item;
        }
        return result;
    }
}
