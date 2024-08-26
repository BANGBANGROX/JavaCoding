import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    List<Node> children;

    Node(int val) {
        this.val = val;
        children = null;
    }
}

class Solution {
    private List<Integer> answer;

    private void postorderTraversal(Node root) {
        if (root == null) return;

        if (root.children != null) {
            for (Node child : root.children) {
                postorderTraversal(child);
            }
        }

        answer.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        answer = new ArrayList<>();

        postorderTraversal(root);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Node root = new Node(1);
       root.children = new ArrayList<>();
       root.children.add(new Node(2));
       root.children.add(new Node(3));
       root.children.getFirst().children = new ArrayList<>();
       root.children.getFirst().children.add(new Node(4));

       System.out.println(new Solution().postorder(root));
   }
}
