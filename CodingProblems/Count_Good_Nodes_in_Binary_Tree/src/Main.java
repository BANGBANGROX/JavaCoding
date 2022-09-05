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
    private int ans;

    private void goodNodesUtil(TreeNode root, int maxValue) {
        if (root == null) return;

        if (root.val >= maxValue) ++ans;

        goodNodesUtil(root.left, Math.max(maxValue, root.val));
        goodNodesUtil(root.right, Math.max(maxValue, root.val));
    }

    public int goodNodes(TreeNode root) {
        ans = 0;

        goodNodesUtil(root, Integer.MIN_VALUE);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.goodNodes(root));
    }
}
