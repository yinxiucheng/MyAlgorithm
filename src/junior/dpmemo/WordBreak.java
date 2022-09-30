package junior.dpmemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/107
 * <p>
 * 描述
 * 给定字符串 s 和单词字典 dict，确定 s 是否可以分成一个或多个以空格分隔的子串，并且这些子串都在字典中存在。
 * 因为我们已经使用了更强大的数据，所以普通的DFS方法无法解决此题。
 */
public class WordBreak {

    public static void main(String[] args) {
        String s= "aaab";
        Set<String> wordSet = new HashSet<>();
        wordSet.add("a");
        wordSet.add("b");
        boolean result = wordBreak(s, wordSet);
        System.out.print("the result is " + result);
    }
    /**
     * @param s:       A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public static boolean wordBreak(String s, Set<String> wordSet) {
        int maxLength = getMaxLength(wordSet);
        Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
        return isMatchHelper(s, 0, maxLength, wordSet, memo);
    }

    private static boolean isMatchHelper(String s, int index, int maxLength, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (memo.containsKey(index)){
            return memo.get(index);
        }
        if (index == s.length()) {
            return true;
        }
        memo.put(index, false);
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (subStr.length() > maxLength) {
                break;
            }
            if (!wordSet.contains(subStr)) {
                continue;
            }
            if (isMatchHelper(s, i + 1, maxLength, wordSet, memo)) {
                memo.put(index, true);
                break;
            }
        }
        return memo.get(index);
    }

    private  static int getMaxLength(Set<String> wordSet) {
        int maxLength = Integer.MIN_VALUE;
        for (String str : wordSet) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }
}

   /* Exception in thread "main" java.lang.StackOverflowError
        at Solution.isMatchHelper(Solution.java:29)
        at Solution.isMatchHelper(Solution.java:29)
        at Solution.isMatchHelper(Solution.java:29)
        at Solution.isMatchHelper(Solution.java:29)
        at Solution.isMatchHelper(Solution.java:29)
        at Solution.isMatchHelper(Solution.java:29)
    */

