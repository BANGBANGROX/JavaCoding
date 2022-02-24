import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    public Node cloneGraph(Node node) {
       HashMap<Node, Node> nodeToClonedNode = new HashMap<>();
       Queue<Node> q = new LinkedList<>();

       if (node == null) return null;

       q.add(node);

       while (!q.isEmpty()) {
           Node currentNode = q.poll();
           if (!nodeToClonedNode.containsKey(currentNode)) {
               Node clonedNode = new Node(currentNode.val);
               nodeToClonedNode.put(currentNode, clonedNode);
           }
           Node clonedNode = nodeToClonedNode.get(currentNode);
           for (Node child : currentNode.neighbors) {
               if (!nodeToClonedNode.containsKey(child)) {
                   Node clonedChild = new Node(child.val);
                   nodeToClonedNode.put(child, clonedChild);
                   q.add(child);
               }
               clonedNode.neighbors.add(nodeToClonedNode.get(child));
           }
       }

       return nodeToClonedNode.get(node);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
