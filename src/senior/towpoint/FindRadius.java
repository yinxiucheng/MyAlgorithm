package senior.towpoint;

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

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int j = 0;
        int n = houses.length;
        int m = heaters.length;
        int maxRadius = 0;
        while (i < n && j < m){
            int curRadius = Math.abs(houses[i] - heaters[j]);
            int nextRadius = Integer.MAX_VALUE;
            if (j < m - 1){
                nextRadius = Math.abs(houses[i] - heaters[j + 1]);
            }
            if (curRadius < nextRadius){
                maxRadius = Math.max(maxRadius, curRadius);
                i++;
            }else {
                j++;
            }
        }
        return maxRadius;
    }
}
