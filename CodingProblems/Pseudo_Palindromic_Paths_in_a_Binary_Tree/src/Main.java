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
    private int ans = 0;

    private void dfs(TreeNode root, int path) {
       if (root == null) return;

       path ^= (1 << root.val);

       if (root.left == null && root.right == null) {
            if ((path & (path - 1)) == 0) ++ans;
       }

       dfs(root.left, path);
       dfs(root.right, path);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.pseudoPalindromicPaths(root));
    }
}
