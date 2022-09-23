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
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean oddOrEven = false;
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return null;

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            Queue<TreeNode> currentNodes = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();
                assert node != null;
                currentNodes.add(node);
                if (node.left != null) {
                    q.add(node.left);
                    currentLevel.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    currentLevel.add(node.right.val);
                }
            }
            if (currentLevel.isEmpty()) break;
            if (!oddOrEven) Collections.reverse(currentLevel);
            oddOrEven = !oddOrEven;
            int idx = 0;
            for (int i = 0; i < n; ++i) {
                TreeNode node = currentNodes.poll();
                assert node != null;
                node.left.val = currentLevel.get(idx);
                node.right.val = currentLevel.get(idx + 1);
                idx += 2;
            }
        }

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.reverseOddLevels(root));
    }
}
