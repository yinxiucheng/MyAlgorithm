package junior.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.lintcode.com/problem/634/?fromId=161&_from=collection
 *
 */
public class WordSquares {

    public static void main(String[] args) {
        String[] words = new String[] {"area","lead","wall","lady","ball"};
        List<List<String>> results = wordSquares(words);
        System.out.print("[");
        for (int i = 0; i < results.size(); i++) {
            List<String> result = results.get(i);
            System.out.print("[");
            for (int j = 0; j < result.size(); j++) {
                System.out.print(result.get(j));
                if (j < result.size() - 1){
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < results.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> results = new ArrayList<>();
        if (null == words || words.length == 0){
            return results;
        }
        int l = words[0].length();
        List<String> path = new ArrayList<>();
        HashMap<String, List<String>> hashMap = initPrefix(words, l);
        for (int i = 0; i < words.length; i++) {
            path.add(words[i]);
            dfs(1, l, hashMap, path, results);
            path.remove(path.size() - 1);
        }
        return results;
    }

    private static void dfs(int x, int l, HashMap<String, List<String>> hashMap, List<String> path, List<List<String>> results){
        if (x == l){
            results.add(new ArrayList<>(path));
            return;
        }
        String prefix = "";
        for (String item: path) {
            prefix += item.charAt(x);
        }
        for (String item: hashMap.getOrDefault(prefix, new ArrayList<>())) {
            if (!checkPrefix(x, l, path, item, hashMap)){
                continue;
            }
            path.add(item);
            dfs(x+1, l, hashMap, path, results);
            path.remove(path.size() - 1);
        }
    }

    private static boolean checkPrefix(int x, int l, List<String> path, String nextWord, HashMap<String, List<String>> hashMap){
        for (int i = x+1; i < l ; i++) {
            String prefix = "";
            for (String item: path) {
                prefix += item.charAt(i);
            }
            prefix += nextWord.charAt(i);
            if (!hashMap.containsKey(prefix)){
                return false;
            }
        }
        return true;
    }

    private static HashMap<String, List<String>> initPrefix(String[] words, int l){
        HashMap<String, List<String>> hashMap = new HashMap<>();
        hashMap.putIfAbsent("", new ArrayList<>());
        for (String word: words) {
            hashMap.get("").add(word);
            String prefix = "";
            for (int i = 0; i < l; i++) {
                prefix += word.charAt(i);
                hashMap.putIfAbsent(prefix, new ArrayList<>());
                hashMap.get(prefix).add(word);
            }
        }
        return hashMap;
    }
}
