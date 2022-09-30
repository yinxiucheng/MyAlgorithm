package junior.sumarrange;

import java.util.Random;

public class RandomPointsRect {
    int[][] rs;
    int[] sum;
    int n;
    Random random = new Random();

    public RandomPointsRect(int[][] rects){
        rs = rects;
        n = rects.length;
        sum = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i-1] + (rs[i-1][2] - rs[i-1][0] + 1)*(rs[i-1][3] - rs[i-1][1] + 1);
        }
    }

    public int[] pick(){
        int val = random.nextInt(sum[n]) + 1;
        int l = 0 , r = sum.length - 1;
        int index;
        while (l + 1 < r){
            int mid = l + r >> 1;
            if (sum[mid] > val) r = mid;
            else if (sum[mid] < val) l = mid;
            else r = mid;
        }
        if (sum[r] == val) index = r;
        else index = l;

        int[] cur = rs[index - 1];
        int x = cur[0] + random.nextInt(cur[2] - cur[0] + 1);
        int y = cur[1] + random.nextInt(cur[3] - cur[1] + 1);
        return new int[]{x, y};
    }
}
