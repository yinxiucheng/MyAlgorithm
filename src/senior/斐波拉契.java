package senior;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/366/?fromId=164&_from=collection
 *
 */
public class 斐波拉契 {

    Map<Integer, Integer> memo = new HashMap<>();

    public int fibonacci(int n) {
        // write your code here
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(memo.containsKey(n)) return memo.get(n);

        int value = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, value);
        return value;
    }
}
