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
    private static class Pair {
        int first;
        TreeNode second;

        Pair(int first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    private Pair pruneTreeUtil(TreeNode root) {
        if (root == null) return new Pair(0, null);

        Pair left = pruneTreeUtil(root.left);
        Pair right = pruneTreeUtil(root.right);

        root.left = left.second;
        root.right = right.second;

        if (left.first == 0 && right.first == 0) {
            if (root.val == 0) return new Pair(0, null);
            return new Pair(1, root);
        }

        return new Pair(root.val + left.first + right.first, root);
    }

    public TreeNode pruneTree(TreeNode root) {
        Pair ans = pruneTreeUtil(root);

        return ans.second;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);

        Solution solution = new Solution();
        System.out.println(solution.pruneTree(root));
    }
}
