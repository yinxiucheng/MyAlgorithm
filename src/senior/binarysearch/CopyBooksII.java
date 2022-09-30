package senior.binarysearch;

/**
 * 438 · 书籍复印 II
 *
 * https://www.lintcode.com/problem/438/?fromId=178&_from=collection
 *
 * 描述
 * 给定 n 本书, 每本书具有相同的页数. 现在有 k 个人来复印这些书. 其中第 i 个人需要 times[i] 分钟来复印一本书. 每个人可以复印任意数量的书.
 * 怎样分配这 k 个人的任务, 使得这 n 本书能够被尽快复印完?
 *
 * 返回完成复印任务最少需要的分钟数.
 *
 *
 */
public class CopyBooksII {

    public int copyBooksII(int n, int[] times) {
        int start = 0;
        int end = times[0] * n;//全部由第一个人抄。

        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (ok(n, times, mid)){//求最少，mid时间下可以抄完，则往左靠。
                end = mid;
            }else{
                start = mid;
            }
        }

        if (ok(n, times, start)){
            return start;
        }
        return end;
    }

    private boolean ok(int n, int[] times, int expends){

        int count = 0;
        for (int i = 0; i < times.length; i++) {
            count += expends/times[i]; //
        }
        return n <= count; //为true 时， 保证可以抄完。
    }
}
