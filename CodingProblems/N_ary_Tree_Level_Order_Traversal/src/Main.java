import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node(int _val) {
        val = _val;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                Node node = q.poll();
                assert node != null;
                currentLevel.add(node.val);
                if (node.children != null) {
                    q.addAll(node.children);
                }
            }
            ans.add(new ArrayList<>(currentLevel));
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);
        Node four = new Node(5);
        root.children = new ArrayList<>(Arrays.asList(one, two, three, four));

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }
}
