package senior.datastucture.tree.middle;

import junior.datamodel.TreeNode;

import java.util.*;

/**
 * https://www.lintcode.com/problem/1506/solution/46911?showListFe=true&page=1&problemTypeId=2&tagIds=371&pageSize=50
 *
 *
 */
public class 二叉树中所有距离为K的结点 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

       Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
       buildGraph(graph, null, root);
       Queue<TreeNode> queue = new LinkedList<>();
       Set<TreeNode> visited = new HashSet<>();

       queue.offer(target);
       visited.add(target);
       int count = 1;
       List<Integer> results = new ArrayList<>();
       while (!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i < size; i++) {
               TreeNode curNode = queue.poll();
               if (count == k){
                   results.add(curNode.val);
               }
               Set<TreeNode> neighbors = graph.getOrDefault(curNode, new HashSet<>());
               for (TreeNode neighbor: neighbors) {
                   if (!visited.contains(neighbor)){
                       queue.offer(neighbor);
                       visited.add(neighbor);
                   }
               }
           }
           if (count == k){
               return results;
           }
           count++;
       }
       return results;
    }

    private void buildGraph(Map<TreeNode, Set<TreeNode>> graph, TreeNode parent, TreeNode root){
        if (root == null){
            return;
        }
        addEdge(graph, root, root.left);
        addEdge(graph, root, root.right);
        addEdge(graph, root, parent);
        buildGraph(graph, root, root.left);
        buildGraph(graph, root, root.right);
    }

    private void addEdge(Map<TreeNode, Set<TreeNode>> graph, TreeNode a, TreeNode b){
        if (b == null){
            return;
        }
        if (!graph.containsKey(a)){
            Set<TreeNode> set = new HashSet<>();
            graph.put(a, set);
        }
        graph.get(a).add(b);
    }
}
