package senior.datastucture.unionfind;

import java.util.*;

/**
 * 1813 · 构造二叉树
 *
 * https://www.lintcode.com/problem/1813/?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 *
 *
 */
public class ConstructBinaryTree {

//            pair.length> = 1。
//            “more children” 表示一个节点有两个以上的节点。
//            “repeat edge” 表示某一条边出现了多次。
//            “have cycle” 表示有一个周期。
//            “more parent” 表示一个节点具有两个父节点或这颗树具有更多根节点。
//            "input error" 表示输入是不正确的。
    public String constructBinaryTree(List<List<String>> pair) {
        // write your code here
        Set<Integer> errorCods = new HashSet<>();
        UnionFind_4 unionFind = new UnionFind_4(errorCods);
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> childToParent = new HashMap<>();

        for (List<String> itemStr: pair) {
            if (itemStr.size() != 2){
                errorCods.add(5);//input error;
            }else {
                char[] str1Array = itemStr.get(0).toCharArray();
                char[] str2Array = itemStr.get(1).toCharArray();
                if (str1Array.length != 1 || str2Array.length != 1){
                    errorCods.add(5);
                    continue;
                }
                int a = str1Array[0] - 'A';
                int b = str2Array[0] - 'A';
                if (a >= 0 && a <= 25 && b >= 0 && b <= 25){
                    if (!graph.containsKey(a)){
                        graph.put(a, new HashSet<>());
                    }else {
                        if (graph.get(a).contains(b)){
                            errorCods.add(2);//重复的边
                        }else if (graph.get(a).size() >= 2){
                            errorCods.add(1);//表示一个节点有两个以上的节点
                        }
                    }
                    graph.get(a).add(b);
                    if (childToParent.containsKey(b)){
                        errorCods.add(4);//多个父亲
                    }else {
                        childToParent.put(b, a);
                    }
                    if (graph.containsKey(b) && graph.get(b).contains(a)){
                        errorCods.add(3);
                    }
                    unionFind.add(a);
                    unionFind.add(b);
                    unionFind.union(a, b);
                }else {
                    errorCods.add(5);
                    continue;
                }

            }
        }

        if (unionFind.sizeUnion > 1){
            errorCods.add(4);
        }
        return getErrorStr(errorCods);
    }

    private String getErrorStr(Set<Integer> errorSet){
        if (errorSet.isEmpty()){
            return "successful";
        }else if (errorSet.contains(1)){
            return "more children";
        }else if (errorSet.contains(2)){
            return "repeat edge";
        }else if (errorSet.contains(3)){
            return "have cycle";
        }else if (errorSet.contains(4)){
            return "more parent";
        }else if (errorSet.contains(5)){
            return "input error";
        }
        return "";
    }




    class UnionFind_4{
        Map<Integer, Integer> father;
        int sizeUnion;
        Set<Integer> errorCods;

        public UnionFind_4(Set<Integer> errorCods){
            father = new HashMap<>();
            this.errorCods = errorCods;
        }

        public void add(int x){
           if (!father.containsKey(x)){
               father.put(x, x);
               sizeUnion ++;
           }
        }

        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father.put(root_a, root_b);
                sizeUnion --;
            }
        }

        public int find(int x){
            int root, now = x, fx = x;
            while (now != father.get(now)){
                now = father.get(now);
            }
            root = now;
            while (fx != root){
                father.put(fx, root);
                fx = father.get(fx);
            }
            return root;
        }
    }
}
