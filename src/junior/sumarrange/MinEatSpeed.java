package junior.sumarrange;

/**
 * https://leetcode.cn/problems/koko-eating-bananas/
 *
 */
public class MinEatSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        if (null == piles || piles.length == 0) return -1;

        if (h < piles.length) return -1;

        int left = 1, right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left + 1 < right) {
            int midSpeed = left + (right - left) / 2;
            if (culSpeed(piles, midSpeed) < h) right = midSpeed;
            else if (culSpeed(piles, midSpeed) > h) left = midSpeed;
            else right = midSpeed;
        }
        if (culSpeed(piles, right) <= h) return right;
        return left;
    }


    private int culSpeed(int[] piles, int speed) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + speed - 1) / speed;
        }
        return time;
    }

}
