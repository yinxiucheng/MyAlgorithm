package junior.recursion;

/**
 * https://www.lintcode.com/problem/366/description
 *
 */
public class Fibonacci {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
