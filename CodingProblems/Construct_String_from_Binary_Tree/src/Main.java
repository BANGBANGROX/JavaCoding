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
    private final StringBuilder ans = new StringBuilder();

    private void dfs(TreeNode root) {
        if (root == null) return;

        ans.append('(');
        ans.append(root.val);

        if (root.left == null && root.right != null) ans.append("()");

        dfs(root.left);
        dfs(root.right);

        ans.append(')');
    }

    public String tree2str(TreeNode root) {
           dfs(root);

           return ans.substring(1, ans.length() - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.tree2str(root));
    }
}
