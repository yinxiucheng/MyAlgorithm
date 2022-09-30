package senior.datastucture.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * 1396 · 集合合并
 *
 * https://www.lintcode.com/problem/1396/?fromId=178&_from=collection
 *
 * 描述
 * 有一个集合组成的list，如果有两个集合有相同的元素，将他们合并。返回最后还剩下几个集合。
 *
 * 输入：list = [[1,2,3],[3,9,7],[4,5,10]]
 * 输出：2 .
 * 样例：剩下[1,2,3,9,7]和[4,5,10]这2个集合。
 */
public class SetUnion {


    public int setUnion(int[][] sets) {
        Set<Integer> dataSet = createDataSet(sets);
        UnionFind unionFind = new UnionFind(dataSet);
        for (int i = 0; i < sets.length; i++) {
            int[] connection = sets[i];
            for (int j = 1; j < connection.length; j++) {
                unionFind.connect(connection[j-1], connection[j]);
            }
        }
        return unionFind.query();
    }

    private Set<Integer> createDataSet(int[][] sets){
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < sets.length; i++) {
            int[] set = sets[i];
            for (Integer item: set) {
                result.add(item);
            }
        }
        return result;
    }
}
