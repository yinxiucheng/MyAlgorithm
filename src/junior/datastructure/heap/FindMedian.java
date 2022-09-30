package junior.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
//        int[][] nums = {{1},{},{2},{3},{3}};
        int[][] nums = {
                {1,3},
                {2147483646,2147483647}
        };
        System.out.print(findMedian(nums));
    }

    private static int getTotalSize(int[][] nums){
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i].length;
        }
        return total;
    }

    public static double findMedian(int[][] nums) {
        int totalLen = getTotalSize(nums);
        if (totalLen == 0){
            return 0;
        }
        Queue<Element> heap = new PriorityQueue<>(nums.length, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length > 0) {
                heap.offer(new Element(i, 0, nums[i][0]));
            }
        }

        int count = 0;
        int[] result = new int[totalLen/2 + 1];
        while (!heap.isEmpty()){
            Element ele = heap.poll();
            result[count++] = ele.val;
            if (count >= totalLen/2 + 1){
                break;
            }
            if (ele.col + 1 < nums[ele.row].length){
                ele.col = ele.col + 1;
                ele.val = nums[ele.row][ele.col];
                heap.add(ele);
            }
        }
        if (totalLen % 2 == 0) { //
            return result[totalLen / 2 - 1]/ 2.0 + result[totalLen/ 2]/ 2.0;
        } else {
            return result[(totalLen + 1) / 2 - 1];
        }
    }

    static class Element{
        int row;
        int col;
        int val;

        Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
