package senior.datastucture.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1390 · 单词的压缩编码
 *
 * https://www.lintcode.com/problem/1390/solution/39605?showListFe=true&page=1&problemTypeId=2&tagIds=397&pageSize=50
 *
 */
public class 单词的压缩编码 {

    TrieNode root;
    public int minimumLengthEncoding(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()){
            TrieNode curNode = queue.poll();
            if (curNode.children.isEmpty()){
                result += curNode.len + 1;
            }
            for (TrieNode child: curNode.children.values()) {
                queue.offer(child);
            }
        }
        return result;
    }

    private void insert(String word){
        String temp = new StringBuilder(word).reverse().toString();
        TrieNode now = root;
        for (Character ch: temp.toCharArray()) {
            if (!now.children.containsKey(ch)){
                now.children.put(ch, new TrieNode());
            }
            now = now.children.get(ch);
        }
        now.len = temp.length();
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        int len;

        TrieNode(){
            children = new HashMap<>();
            len = 0;
        }
    }
}
