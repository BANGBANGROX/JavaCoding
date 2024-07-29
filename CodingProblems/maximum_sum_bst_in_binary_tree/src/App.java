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
    private int answer;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 }; // {minValue, maxValue, overallSum};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (left == null || right == null || root.val <= left[1] || root.val >= right[0]) {
            return null;
        }

        int currentSum = left[2] + right[2] + root.val;

        answer = Math.max(answer, currentSum);

        return new int[] { Math.min(root.val, left[0]), Math.max(root.val, right[1]), currentSum };
    }

    public int maxSumBST(TreeNode root) {
        answer = 0;

        dfs(root);

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new Solution().maxSumBST(root));
    }
}
