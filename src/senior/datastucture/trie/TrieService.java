package senior.datastucture.trie;

import java.util.*;

public class TrieService {

    class TrieNode{
        public NavigableMap<Character, TrieNode> children;
        public List<Integer> top10;

        public TrieNode() {
          children = new TreeMap();
          top10 = new ArrayList();
        }
    }

    private TrieNode root = null;
    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (curNode.children.get(c) == null){
                curNode.children.put(c, new TrieNode());
            }
            curNode = curNode.children.get(c);
            curNode.top10.add(frequency);
            Collections.sort(curNode.top10, (o1, o2) -> o2 - o1);
        }
    }
}
