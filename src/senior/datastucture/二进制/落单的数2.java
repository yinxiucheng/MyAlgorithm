package senior.datastucture.二进制;

/**
 * 83 · 落单的数 II
 *
 * https://www.lintcode.com/problem/83/?showListFe=true&page=2&problemTypeId=2&tagIds=349&pageSize=50
 *
 * 描述
 * 给出3*n + 1 个非负整数，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
 *
 */
public class 落单的数2 {

    public int singleNumberII(int[] A) {
        int[] bits = new int[32];
        int result = 0;

        for (int i = 0; i < 32; i++) {

            for (int j = 0; j < A.length; j++) {
                bits[i] += A[j]>>i & 1;
                bits[i] %= 3;
            }

            result |= bits[i] << i;
        }
        return  result;
    }
}
