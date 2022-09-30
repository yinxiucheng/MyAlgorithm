package junior.twopointer.towsum;

import java.util.Arrays;

/**
 * 382 · 三角形计数
 *
 * 描述
 * 给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
 *
 * a + b > c
 *
 */
public class TriangleCount {

    /**
     * @param s: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] s) {
        if (null == s || s.length < 3){
            return 0;
        }
        Arrays.sort(s);
        int ans = 0;
        for (int i = s.length - 1; i >= 2 ; i--) {
            int c = s[i];
            int start = 0;
            int end = i - 1;
            while (start < end){
                if (s[start] + s[end] <= c){
                    start ++ ;
                }else {
                    ans += end - start;
                    end --;
                }
            }
        }

        return ans;

    }
}
