class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    private static class Pair {
        int depth;
        TreeNode node;

        public Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaDeepestLeavesHandler(root, 0).node;
    }

    private Pair lcaDeepestLeavesHandler(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return new Pair(depth, root);
        }

        if (root.left == null) {
            return lcaDeepestLeavesHandler(root.right, depth + 1);
        }

        if (root.right == null) {
            return lcaDeepestLeavesHandler(root.left, depth + 1);
        }

        Pair left = lcaDeepestLeavesHandler(root.left, depth + 1);
        Pair right = lcaDeepestLeavesHandler(root.right, depth + 1);

        if (left.depth == right.depth) return new Pair(left.depth, root);

        if (left.depth > right.depth) return new Pair(left.depth, left.node);

        return new Pair(right.depth, right.node);
    }
}

public class Main {
   public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);

       System.out.println(new Solution().lcaDeepestLeaves(root));
   }
}
