package senior.datastucture.tree.ntree;

import java.util.*;

/**
 * https://www.lintcode.com/problem/1532/
 *
 * 输入：{1,3,2,4#2#3,5,6#4#5#6}
 * 输出：{1,3,2,4#2#3,5,6#4#5#6}
 *
 */
public class 序列化和反序列N叉树 {

    public class Solution {

        public String serialize(ArrayList<DirectedGraphNode> nodes) {
            Queue<DirectedGraphNode> queue = new LinkedList<>();
            for (int i = 0; i < nodes.size(); i++) {
                queue.offer(nodes.get(i));
            }
            StringBuilder builder = new StringBuilder();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    DirectedGraphNode curNode = queue.poll();
                    if (i != size - 1) {
                        builder.append(curNode.label).append(",");
                    } else {
                        builder.append(curNode.label);
                    }
                    for (DirectedGraphNode neighbor : curNode.neighbors) {
                        queue.offer(neighbor);
                    }
                }
                builder.append("#");//最后多一个。
            }
            return builder.toString();
        }

        /**
         * 输入：{1,3,2,4#2#3,5,6#4#5#6}
         * 输出：{1,3,2,4#2#3,5,6#4#5#6}
         */
        public UndirectedGraphNode deserialize(String data) {
            String[] subStrArray = data.split("#");
            HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
            int wapperCount = 0;
            UndirectedGraphNode wapperRoot = null;
            for (String subStr: subStrArray) {
                String[] values = subStr.split(",");
                int count = 0;
                UndirectedGraphNode root = null;
                for (String value: values) {
                    int valueInt = Integer.parseInt(value);
                    if (!map.containsKey(valueInt)){
                        UndirectedGraphNode node = new UndirectedGraphNode(valueInt);
                        map.put(valueInt, node);
                    }
                    if (count == 0){
                        root = map.get(valueInt);
                    }else {
                        root.neighbors.add(map.get(valueInt));
                    }
                    count ++;
                }
                if (wapperCount == 0){
                    wapperRoot = root;
                }
                wapperCount ++;
            }
            return wapperRoot;
        }
    }


    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
