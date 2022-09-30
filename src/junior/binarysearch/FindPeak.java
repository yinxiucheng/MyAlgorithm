package junior.binarysearch;

/**
 * 75 · 寻找峰值
 *
 * https://www.lintcode.com/problem/75/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个整数数组(size为n)，其具有以下特点：
 *
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 *
 * 数组保证至少存在一个峰
 * 如果数组存在多个峰，返回其中任意一个就行
 * 数组至少包含 3 个数
 *
 */
public class FindPeak {

    /**
     * @param a: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] a) {
        int start = 0;
        int end = a.length - 1;

        while (start + 2 < end){// 出循环最后一定三个数。
            int mid = start + (end - start)/2;
            if (a[mid] > a[mid -1] && a[mid]> a[mid + 1]){ //峰值返回。
                return mid;
            }

            if (a[mid-1] < a[mid]  && a[mid] < a[mid + 1]){//递增， 峰在右边
                start = mid;
            }else if(a[mid + 1] < a[mid]  && a[mid] < a[mid - 1]){//单调减， 峰在左边。
                end = mid;
            }else {// mid 在谷底，随意。
                end = mid;
            }
        }

        int mid = start + 1;
        if (a[mid] > a[start] && a[mid] > a[end]){
            return mid;
        }
        if (a[start] > a[mid]){
            return start;
        }
        if (a[end] > a[mid]){
            return end;
        }
        return -1;
    }

}
