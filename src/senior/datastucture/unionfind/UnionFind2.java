package senior.datastucture.unionfind;

public class UnionFind2 {

    int[] father;
    int[] size;

    public UnionFind2(int count){
        father = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }


    public void union(int a, int b){
        int root_a = compress_find(a);
        int root_b = compress_find(b);
        if (root_a != root_b){
            father[root_a] = root_b;
            size[root_b] += size[root_a];
        }
    }

    public int compress_find(int x){
        int root = x, fx, fa = x;
        while (root != father[root]){
            root = father[root];
        }
        while (fa != root){//路径压缩
            fx = father[fa];
            father[fa] = root;
            fa = fx;
        }
        return root;
    }

    public int getSize(int x){
        return size[x];
    }

}
