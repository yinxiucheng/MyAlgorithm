package junior.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 */
public class SearchSubString {

    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr1(String source, String target) {
        // Write your code here
        char[] strA = source.toCharArray();
        char[] strB = target.toCharArray();
        int n = strA.length;
        int m = strB.length;
        if (n < m) return -1;

        for (int i = 0; i <= n - m; i++) {
            int a = i, j = 0;
            for (; j < m; j++) {
                if(strA[a + j] != strB[j]) break;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (j == m) return i;
        }
        return -1;
    }


    public int strStr(String source, String target) {
        // Write your code here
        int n = source.length();
        int m = target.length();
        if (n < m) return -1;

        for (int i = 0; i <= n - m; i++) {
           String str =  source.substring(i, i + m);
           if (str.equals(target)) return i;
        }
        return -1;
    }
}
