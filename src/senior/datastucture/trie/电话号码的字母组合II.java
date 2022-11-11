package senior.datastucture.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 270 · 电话号码的字母组合II
 *
 * https://www.lintcode.com/problem/270/?showListFe=true&page=1&problemTypeId=2&tagIds=397&pageSize=50
 *
 */
public class 电话号码的字母组合II {

    char[] chars = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};

    public int[] letterCombinationsII(String[] queries, String[] dict) {
        Trie trie = new Trie();
        for (String word: dict) {
            char[] charArray = new char[word.length()];
            for (int i = 0; i < charArray.length; i++) {
                int index = word.charAt(i) - 'a';
                charArray[i] = chars[index];
            }
            trie.insert(charArray);
        }

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String queryPreFix = queries[i];
            results[i] = trie.query(queryPreFix);
        }
        return results;
    }

    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        public void insert(char[] strArray){
            TrieNode node = root;
            for (Character ch : strArray) {
                if (!node.children.containsKey(ch)){
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
                node.times ++;
            }
            node.isEnd = true;
        }

        public int query(String prefix){
            TrieNode node = root;
            for (Character ch: prefix.toCharArray()) {
                if (node.children.containsKey(ch)){
                    node = node.children.get(ch);
                }else {
                    return 0;
                }
            }
            return node.times;
        }
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        int times;
        boolean isEnd;

        public TrieNode(){
            children = new HashMap<>();
            times = 0;
        }
    }
}
