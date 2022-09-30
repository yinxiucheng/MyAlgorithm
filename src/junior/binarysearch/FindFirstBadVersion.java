package junior.binarysearch;

/**
 * 74 · 第一个错误的代码版本
 *
 * https://www.lintcode.com/problem/74/?fromId=161&_from=collection
 *
 * 描述
 * 代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。
 *
 * 你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，具体接口详情和调用方法请见代码的注释部分。
 *
 */
public class FindFirstBadVersion {

    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (!isBadVersion(mid)){
                start = mid;
            }else {
                end = mid;
            }
        }

        if (isBadVersion(start)){
            return start;
        }

        if (isBadVersion(end)) {
           return end;
        }

        return -1;
    }

    private boolean isBadVersion(int k){
        return  (Math.random() * 10) % 2 == 0;
    }
}
