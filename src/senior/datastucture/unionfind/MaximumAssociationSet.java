package senior.datastucture.unionfind;

import java.util.*;

/**
 * 805 · 最大关联集合
 *
 * https://www.lintcode.com/problem/805/?fromId=178&_from=collection
 *
 * 亚麻卖书，每本书都有与其关联性很强的书，给出ListA与ListB，表示ListA[i]与ListB[i]有关联，输出互相关联的最大集合。(输出任意顺序)，题目保证只有一个最大的集合。
 *
 */
public class MaximumAssociationSet {

    public static void main(String[] args) {
        String[] listA = {"abc","abc","abc"};
        String[] listB = {"bcd","acd","def"};
       List<String> result =  maximumAssociationSet(listA, listB);
       System.out.println("the result is " + result);
    }

    //书籍编号
    static ConnectingGraph3 unionFind = null;
    static Map<String, Integer> nameToIds = new HashMap<>();
    // name 记录数字编号->书籍名称
    static HashMap<Integer, String> idToName = new HashMap();
    public static List<String> maximumAssociationSet(String[] listA, String[] listB) {
        initUnion(listA, listB);
        int len = Math.min(listA.length, listB.length);
        for (int i = 0; i < len; i++) {//关联
            unionFind.connect(nameToIds.get(listA[i]), nameToIds.get(listB[i]));
        }

        Map<Integer, Set<Integer>> graph = unionFind.buildGraph();
        Set<Integer> maxSet = null;
        int maxSize = 0;
        for (Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()) {
            if (entry.getValue().size() > maxSize){
               maxSize = entry.getValue().size();
               maxSet =  entry.getValue();
            }
        }
        List<String> result = new ArrayList<>();
        for (Integer id: maxSet) {
            result.add(idToName.get(id));
        }
        Collections.sort(result);
        return result;
    }



    private static void initUnion(String[] listA, String[] listB){
        int n = 0;
        for (String value : listA) {
            if (!nameToIds.containsKey(value)) {
                nameToIds.put(value, n);
                idToName.put(n, value);
                n++;
            }
        }
        for (String value : listB) {
            if (!nameToIds.containsKey(value)) {
                nameToIds.put(value, n);
                idToName.put(n, value);
                n++;
            }
        }
        unionFind = new ConnectingGraph3(nameToIds.size());
    }

}
