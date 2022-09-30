package senior.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 333 · 识别字符串
 * https://www.lintcode.com/problem/333/?fromId=178&_from=collection
 *
 *
 */
public class ShortPerfix {


    public static void main(String[] args) {

       String[] array = {"chbab","chbag"};
       String[] reulsts = shortPerfix(array);

    }
    public static String[] shortPerfix(String[] stringArray) {
        TrieTree trieTree = new TrieTree();
        for (String word : stringArray) {
            trieTree.insert(word);
        }

        String[] results = new String[stringArray.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = trieTree.getUniPrefix(stringArray[i]);
        }

        return results;
    }


    static class TrieNode{
        Map<Character, TrieNode> child;
        int visited = 0;
        boolean isWord;

        TrieNode(){
           child = new HashMap<>();
           visited = 1;
        }
    }

   static class TrieTree{
        TrieNode root;

        TrieTree(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode now = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (now.child.get(c) == null){
                    now.child.put(c, new TrieNode());
                }
                now.child.get(c).visited ++;//todo 记录路过的次数
                now = now.child.get(c);
            }
            now.isWord = true;
        }

        public String getUniPrefix(String word){
            TrieNode now = root;
            StringBuilder build = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                TrieNode child = now.child.get(c);
                if ( child == null){
                    return "";
                }

                if (child.visited > 1){
                    build.append(c);
                }else {
                    build.append(c);
                    break;
                }
                now = child;
            }
            return build.toString();
        }
    }
}
