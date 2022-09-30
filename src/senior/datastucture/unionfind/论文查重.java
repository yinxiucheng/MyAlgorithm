package senior.datastucture.unionfind;

import java.util.List;

/**
 * 1463 · 论文查重
 *
 * https://www.lintcode.com/problem/1463/?fromId=178&_from=collection
 *
 * 描述
 * 我们定义，两个论文的相似度为最长的相似单词子序列长度 * 2 除以两篇论文的总长度。
 * 给定两篇论文words1，words2（每个表示为字符串数组），和相似单词对列表pairs，求两篇论文的相似度。
 *
 * 注意：相似关系是可传递的。例如，如果“great”和“good”类似，而“fine”和“good”类似，那么“great”和“fine”类似。
 * 相似性也是对称的。 例如，“great”和“good”相似，则“good”和“great”相似。
 * 另外，一个词总是与其本身相似。
 *
 * 输入：words1= ["great","acting","skills","life"]，words2= ["fine","drama","talent","health"]，pairs=  [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]]
 * 输出：：0.75
 * 解释：
 * 两篇单词相似的子单词序列为
 * "great","acting","skills"
 * "fine","drama","talent"
 * 总长度为8
 * 相似度为6/8=0.75`
 *
 */
public class 论文查重 {

    public float getSimilarity(List<String> words1, List<String> words2, List<List<String>> pairs) {

        return 0.0f;
    }
}
