package senior.datastucture.trie;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class 回文对 {

    public static void main(String[] args) {
        String[] words = {"bat","tab","cat"};
        palindromePairs(words);
    }

    public static List<List<Integer>> palindromePairs(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseStr = new StringBuilder(word).reverse().toString();
            map.put(reverseStr, i);
        }

        List<List<Integer>> ansResult = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {//todo 这里需要 j <=  因为 subString(0, j) ， j 为闭区间。
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (map.containsKey(left)){
                    int index = map.get(left);
                    if (i != index && isPalindromeStr(right)){
                        Integer[] array = new Integer[]{index, i};
                        ansResult.add(Arrays.asList(array));
                    }
                }

                if (map.containsKey(right)){
                    int index = map.get(right);
                    if (i != index && isPalindromeStr(left) && !left.equals("")){
                        Integer[] array = new Integer[]{i, index};
                        ansResult.add(Arrays.asList(array));
                    }
                }
            }
        }
        ansResult.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        return ansResult;
    }

    private static boolean isPalindromeStr(String word){
        String temp = new StringBuilder(word).reverse().toString();
        return temp.equals(word);
    }
}
