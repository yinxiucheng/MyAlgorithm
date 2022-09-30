package junior.sumarrange;

import java.util.Arrays;

public class MatchSticks {

    public static void main(String[] args) {
        int[] matchsticks = new int[] {1,1, 2, 2, 2};
        boolean match = makeSquare(matchsticks);
        System.out.print("makeSquare is :" + match);
    }

    public static boolean makeSquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0){
            return false;
        }
        int edgeLen = sum / 4;// 边长
        int[] edge = new int[4];// 四条边
        int index = 0;
        Arrays.sort(matchsticks);
        for (int i = 0, j=matchsticks.length - 1; i < matchsticks.length && j>0 ; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return dfs(index, matchsticks, edge, edgeLen);
    }

    public static boolean dfs(int index, int[] matchsticks, int[] edge, int edgeLen){
        if (index == matchsticks.length) return true;

        for (int i = 0; i < edge.length; i++) {
            edge[i] += matchsticks[index];
            //如果 加入 第 index根火柴能够加入到 第 i 条边中去，并且后续的 index + 1 根都能加入，则返回true.
            if (edge[i] <= edgeLen && dfs(index + 1, matchsticks, edge, edgeLen)){
                return true;
            }
            //退出当前的那条边，找下一个桶。
            edge[i] -= matchsticks[index];
        }
        return false;
    }

}
