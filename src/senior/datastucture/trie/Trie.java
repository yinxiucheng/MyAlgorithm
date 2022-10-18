package senior.datastucture.trie;

/**
 * 442 · 实现 Trie（前缀树）
 *
 * https://www.lintcode.com/course/7/learn/442?chapterId=43&sectionId=2056&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A7%22%7D&ac=false
 *
 */
public class Trie {
    boolean isWord;
    Trie[] child;
    String word;
    public Trie() {
        child = new Trie[26];
        for (int i = 0; i < 26; i++) {
            child[i] = null;
        }
        isWord = false;
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        Trie curNode = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curNode.child[index] == null){
                curNode.child[index] = new Trie();
            }
            curNode = curNode.child[index];
        }
        curNode.isWord = true;
        curNode.word = word;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        Trie p = this;
        for (int i = 0; i < word.length() ; i++) {
            int index = word.charAt(i) - 'a';
            if (p.child[index] == null){
                return false;
            }
            p = p.child[index];
        }
        return p.isWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie p = this;
        for (int i = 0; i < prefix.length() ; i++) {
            int index = prefix.charAt(i) - 'a';
            if (p.child[index] == null){
                return false;
            }
            p = p.child[index];
        }
        return true;
    }
}
