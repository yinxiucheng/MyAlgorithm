package junior.common;

/**
 * 414 · 两个整数相除
 *
 * https://www.lintcode.com/problem/414/solution/17106
 *
 * 描述
 * 将两个整数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 如果溢出(超出32位有符号整型表示范围)，返回 2147483647 。
 *
 * 整数除法应向零取整。
 */
public class Divide {

    public static void main(String[] args) {
        int dividend = 3;
        int divisor = 4;
        int result = divide(5, 2);
        System.out.print("the result is " + result);
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0){
           return dividend>=0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0){
            return 0;
        }

        if (dividend == Integer.MAX_VALUE && divisor == -1){
            return Integer.MIN_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result : result;
    }
}
