package senior.dfs.单词搜索;

public class Trie {

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character  c = word.charAt(i);
            if (now.child.get(c) == null){
                now.child.put(c, new TrieNode());
            }
            now = now.child.get(c);
        }
        now.word = word;
    }
}
