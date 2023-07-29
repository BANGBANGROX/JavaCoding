import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    private List<Integer> answer;
    private HashMap<Integer, ArrayList<Integer>> graph;
    private HashSet<Integer> visited;
    private int k;

    private void constructGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;

        if (parent != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(root.val);
        }

        constructGraph(root.left, root);
        constructGraph(root.right, root);
    }

    private void dfs(int node, int distance) {
        visited.add(node);

        if (distance == k) {
            answer.add(node);
            return;
        }

        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(child)) {
                dfs(child, distance + 1);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        answer = new ArrayList<>();
        graph = new HashMap<>();
        visited = new HashSet<>();
        this.k = k;

        assert target != null;

        constructGraph(root, null);
        dfs(target.val, 0);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.distanceK(root, root.left, 2));
    }
}
