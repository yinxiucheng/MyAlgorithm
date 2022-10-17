package senior.datastucture.二进制;

/**
 * 82 · 落单的数
 *
 * https://www.lintcode.com/problem/82/?showListFe=true&page=2&problemTypeId=2&tagIds=349&pageSize=50
 *
 */
public class 落单的数 {

    public int singleNumber(int[] a) {

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result ^ a[i];
        }
        return result;
    }
}
