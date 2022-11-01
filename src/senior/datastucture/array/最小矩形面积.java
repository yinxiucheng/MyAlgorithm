package senior.datastucture.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/1703/description
 *
 *
 */
public class 最小矩形面积 {

    public int minimumAreaRectangle(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] item: points) {
            set.add(item[0] * 40001 + item[1]);
        }
        int size = points.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < size ; i++) {
            for (int j = i+ 1; j < size; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];

                //找出对角线的点。
                if (point1[0] == point2[0] || point1[1] == point2[1]){
                    continue;
                }
                int area = Math.abs((point1[0] - point2[0]) * (point1[1] - point2[1]));
                if (area > result){
                    continue;
                }
                if (area < result && set.contains(point1[0] * 40001 + point2[1])
                        && set.contains(point2[0] * 40001 + point1[1])){
                    result = area;
                }
            }
        }
        return result;
    }
}
