class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        left = right = null;
        this.val = val;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (root.left != null) {
            left = minDepth(root.left);
        }

        if (root.right != null) {
            right = minDepth(root.right);
        }

        return Math.min(left, right) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }
}
