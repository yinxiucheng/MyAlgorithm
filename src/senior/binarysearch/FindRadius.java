package senior.binarysearch;

import java.util.Arrays;

/**
 * 1219 · 加热器
 *
 * https://www.lintcode.com/problem/1219/
 *
 * 描述
 * 冬天来啦！你的任务是设计出一个具有固定加热半径的加热器，使得所有房屋在这个冬天不至于太冷。
 *
 * 现在你能够获知所有房屋和加热器所处的位置，它们均分布在一条水平线中。你需要找出最小的加热半径使得所有房屋都处在至少一个加热器的加热范围内。
 *
 * 所以，你的输入将会是所有房屋和加热器所处的位置，期望输出为加热器最小的加热半径。
 *
 * 双指针  解法。
 *
 */
public class FindRadius {

    public static void main(String[] args) {

        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        int result = findRadius(houses, heaters);
        System.out.println("the result is " + result);
    }

    public static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        int ansMax = 0;
        for (int i = 0; i < houses.length; i++) {
            int minHeatLen = binarySearch(houses[i], heaters);
            ansMax = Math.max(ansMax, minHeatLen);
        }
        return ansMax;
    }

    private static int binarySearch(int val, int[] heaters){
        int start = 0, end = heaters.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (heaters[mid] >= val){
                end = mid;
            }else {
                start = mid;
            }
        }

        int leftRadius = Math.abs(heaters[start] - val);
        int rightRadius = Math.abs(heaters[end] - val);
        return Math.min(leftRadius, rightRadius);
    }
}
