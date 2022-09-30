package senior.towpoint;

/**
 * 1850 · 捡苹果
 *
 * https://www.lintcode.com/problem/1850/?fromId=178&_from=collection
 *
 * Alice 和 Bob 在一个漂亮的果园里面工作，果园里面有N棵苹果树排成了一排，这些苹果树被标记成1 - N号。
 * Alice 计划收集连续的K棵苹果树上面的所有苹果，Bob 计划收集连续的L棵苹果树上面的所有苹果。
 * 他们希望选择不相交的部分（一个由 Alice 的K树组成，另一个由鲍勃 Bob 的L树组成），以免相互干扰。你应该返回他们可以收集的最大数量的苹果。
 *
 */
public class PickApples {

    public static void main(String[] args) {
        int[] a = {4,5,4,5,6,4,7,10,9,1};
        int ans = pickApples(a, 1, 4);
        System.out.println("the ans is " + ans);
    }

    public static int pickApples(int[] a, int k, int l) {
        int n = a.length;

        int ans = 0;
        int firstAns = 0;
        int secondAns = 0;
        for (int i = 0; i < n ; i++) {
            //左k, 右l
            int maxLeft = getMaxApple(a, 0, i, k);
            int maxRight = getMaxApple(a, i, n, l);
            if (maxLeft == -1 || maxRight == -1){
                firstAns = Math.max(firstAns, -1);
            }else {
                firstAns = Math.max(firstAns, maxLeft + maxRight);
            }

        }
        System.out.println("the firstAns is " + firstAns);

        for (int i = 0; i < n ; i++) {
            //左l, 右k
            int maxLeft = getMaxApple(a, 0, i, l);
            int maxRight = getMaxApple(a, i, n, k);
            if (maxLeft == -1 || maxRight == -1){
                secondAns = Math.max(secondAns, -1);
            }else {
                secondAns = Math.max(secondAns, maxLeft + maxRight);
            }
        }

        System.out.println("the secondAns is " + secondAns);
        ans = Math.max(firstAns, secondAns);
        return ans;
    }

    private static int getMaxApple(int[] apples, int start, int end, int k){
        if (end - start < k){
            return -1;
        }
        int sum = 0;
        for (int i = start; i < start + k ; i++) {
            sum += apples[i];
        }

        int ans = sum;
        for (int i = start + k; i < end ; i++) {
            sum -= apples[i-k];
            sum += apples[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
