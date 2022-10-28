package senior.towpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 1643 · 摘水果
 * https://www.lintcode.com/problem/1643/
 *
 * 描述
 * 小红去果园采水果。有2个篮子，可以装无数个水果，但是只能装一种水果。从任意位置的树开始，往右采。
 * 遇到2种情况退出，1. 遇到第三种水果，没有篮子可以放了，2. 到头了。返回可以采摘的最多的水果个数。水果数组用arr表示。
 *
 * 输入：[1,2,1,3,4,3,5,1,2]
 * 输出：3
 * 解释：
 * 选择[1, 2, 1] 或 [3, 4, 3]。 长度是3。
 *
 */
public class 摘水果 {

    public int pickFruits(int[] arr) {
       int differentNumber = 0;
       int result = 0;
       Map<Integer, Integer> count = new HashMap<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && differentNumber < 3){
                count.put(arr[j], count.getOrDefault(arr[j], 0) + 1);
                if (count.get(arr[j]) == 1){
                    differentNumber += 1;
                }
                j++;
                if (differentNumber <= 2){
                    result = Math.max(result, j - i);
                }
            }
            count.put(arr[i], count.get(arr[i]) - 1);
            if (count.get(arr[i]) == 0){
                differentNumber -= 1;
            }
        }
        return result;
    }
}
