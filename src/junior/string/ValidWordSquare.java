package junior.string;

/**
 * https://www.lintcode.com/problem/888
 *
 * 描述
 * 给定一个单词序列，检查它是否构成一个有效单词方阵。
 * 一个有效的单词方阵应满足以下条件：对于满足0≤k<max(numRows numColumns)的k，第k行和第k列对应的字符串应该相同,。
 */
public class ValidWordSquare {

    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (word.length() != n){
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (words[i].charAt(j) != words[j].charAt(i))
                    return false;
            }
        }
        return true;
    }
}
