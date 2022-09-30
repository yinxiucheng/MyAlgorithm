package junior.binarysearch;

/**
 * 140 · 快速幂
 *
 * https://www.lintcode.com/problem/140/
 *
 */
public class FasterPower {

    public int fastPower(int a, int b, int n) {
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }

        long result = 0;
        long product = fastPower(a, b, n / 2);
        result = (product * product) % b;
        if (n % 2 == 1) {
            result = (result * a) % b;
        }
        return  (int)result;
    }
}
