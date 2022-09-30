package junior.common;

/**
 * 845 · 最大公约数
 *
 * 描述
 * 给两个数字，数字 a 跟数字 b。找到两者的最大公约数。
 */
public class Gcd {

    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        if (a < b) gcd(b, a);

        if (a % b == 0) return b;

        return gcd(b, a%b);
    }
}
