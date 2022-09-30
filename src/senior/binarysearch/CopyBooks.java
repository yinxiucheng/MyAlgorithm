package senior.binarysearch;

/**
 * 437 · 书籍复印
 *
 * https://www.lintcode.com/problem/437/?showListFe=true&page=1&problemTypeId=2&tagIds=419&pageSize=50
 *
 * 描述
 * 给定n本书，第i本书有pages[i]页。有k个人来抄这些书。
 *
 * 这些书排成一行，每个人都可以索取连续一段的书。例如，一个抄书人可以连续地将书从第i册复制到第j册，但是他不能复制第1册、第2册和第4册（没有第3册）。
 *
 * 他们在同一时间开始抄书，每抄一页书都要花1分钟。为了让最慢的抄书人能在最早的时间完成书的分配，最好的策略是什么？
 *
 * 请返回最慢抄书人花费的最短时间。
 *
 *
 * 输入: pages = [3, 2, 4], k = 2
 * 输出: 5
 * 解释: 第一个人复印前两本书, 耗时 5 分钟. 第二个人复印第三本书, 耗时 4 分钟.
 */
public class CopyBooks {

    public static void main(String[] args) {
        int[] pages = {3,2,4};
        int k = 2;
        int result = copyBooks(pages, k);
        System.out.println("the result is " + result);
    }

    public static int copyBooks(int[] pages, int k) {
        // 派一个人抄，其它人休息，时间最长。
        //每个人操一本，最慢的那个， 最大的值

        int end = 0;
        int start = 0;

        for (int i = 0; i < pages.length; i++) {
            end += pages[i];
            start = Math.max(start, pages[i]);
        }
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (canFinish(pages, k, mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        if (canFinish(pages, k, start)){
            return start;
        }
        return end;
    }

    //k个人在 value的时间内能否抄完 pages本书。
    private static boolean canFinish(int[] pages, int k, int value){
        int left = value;
        int count = 1;
        for (int i = 0; i < pages.length; i++) {
            if (left >= pages[i]) {
                left -= pages[i];
            } else {
                left = value;
                left -= pages[i];
                count++;
            }
        }
        return count <= k;
    }
}
