package junior.datamodel;

import java.util.ArrayList;

public class DirectedGraphNode {
    public int index;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int index){
        this.index = index;
        neighbors = new ArrayList<>();
    }
}
