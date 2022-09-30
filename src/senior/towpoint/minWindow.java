package senior.towpoint;

/**
 * 32 · 最小子串覆盖
 *
 * https://www.lintcode.com/problem/32/
 *
 *  描述
 * 给定两个字符串 source 和 target. 求 source 中最短的包含 target 中每一个字符的子串.
 */
public class minWindow {

    public String minWindow(String source, String target) {
        //预处理
        int[] targetSet = new int[256];

        //不依赖于系统的default值
        for (int i = 0; i < target.length(); i++) {
            targetSet[i] = 0;
        }

        int K = 0;
        for (int i = 0; i < target.length() ; i++) {
            int c = target.charAt(i);
            targetSet[c] = targetSet[c] + 1;
            if (targetSet[c] == 1){
                K++;
            }
        }

        int j = 0;
        int S = 0;
        int[] sourceSet = new int[256];
        int minLen = Integer.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = 0;
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && S < K){
                int c = source.charAt(j);
                if (targetSet[c] > 0){
                    sourceSet[c] += 1;
                    if (sourceSet[c] == targetSet[c] - 1){
                        S ++;
                    }
                }
                j++;
            }

            if (S == K){
                minLen = Math.min(minLen, j - i);
                ansLeft = i;
                ansRight = j;
            }
            int iChar = source.charAt(i);
            if (targetSet[iChar] > 0){
                sourceSet[iChar]--;
            }
        }

        return source.substring(ansLeft, ansRight);
    }

}
