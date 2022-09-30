package junior.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 235 · 分解质因数
 *
 * https://www.lintcode.com/problem/235/
 *
 * 描述
 * 将一个整数分解为若干质因数之乘积。
 *
 */
public class PrimeFactorization {

    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
       double up = Math.sqrt(num);

       List<Integer> result = new ArrayList<>();
        for (int k = 2; k * k <= num && num > 1; k++) {
            while (num % k == 0){
                result.add(k);
                num = num/k;
            }
        }

        if (num > 1){
            result.add(num);
        }

        return result;
    }
}
