package junior.dpmemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/683/?fromId=161&_from=collection
 *
 * 描述
 * 给出一个单词表和一条去掉所有空格的句子，根据给出的单词表添加空格, 返回可以构成的句子的数量, 保证构成的句子中所有的单词都可以在单词表中找到.
 */
public class WordBreakIII {

    public static void main(String[] args) {
        String s = "Cmat";
        Set<String> dict = new HashSet<>();
        dict.add("c");
        dict.add("mat");
        int result =  wordBreak3(s, dict);
        System.out.print("the result is " + result);
    }

    /**
     * @param s: A string
     * @param dict: A set of word
     * @return: the number of possible sentences.
     */
    public static int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        Map<Integer, Integer> memo = new HashMap<>();
        LowDict lowDict = new LowDict(dict);
        return  dfs(s.toLowerCase(), 0, lowDict.maxLength, lowDict.lowDict,  memo);
    }

    private static int dfs(String s, int index, int maxLength,Set<String> dict,  Map<Integer, Integer> memo){
        if (index == s.length()){
            return 1;
        }
        if (memo.containsKey(index)){
            return memo.get(index);
        }
        memo.put(index, 0);
        for (int i = index; i < s.length(); i++) {
            String word = s.substring(index, i+1);
            if (word.length() > maxLength){
                break;
            }
            if (!dict.contains(word)){
                continue;
            }
            int count = dfs(s,  i+1, maxLength, dict, memo);
            memo.put(index, memo.get(index) + count);
        }
        return memo.get(index);
    }

    static class LowDict{
        int maxLength;
        Set<String> lowDict;
        public LowDict(Set<String> dict){
            maxLength = Integer.MIN_VALUE;
            lowDict = new HashSet<>();
            for (String str: dict) {
                maxLength = Math.max(maxLength, str.length());
                lowDict.add(str.toLowerCase());
            }
        }
    }

}
