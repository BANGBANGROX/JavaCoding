import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
    private long ans;
    private final HashMap<TreeNode, ArrayList<Integer>> subtreeSums = new HashMap<>();

    private int calculateSubtreeSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = calculateSubtreeSum(root.left);
        int rightSum = calculateSubtreeSum(root.right);

        subtreeSums.put(root, new ArrayList<>(Arrays.asList(leftSum, rightSum)));

        return leftSum + rightSum + root.val;
    }

    private void maxProductUtil(TreeNode root, long sum) {
        if (root == null) return;

        long leftSum = subtreeSums.get(root).get(0);
        long rightSum = subtreeSums.get(root).get(1);

        ans = Math.max(ans, Math.max((leftSum + root.val + sum) *
                rightSum, (rightSum + root.val + sum) * leftSum));

        maxProductUtil(root.left, sum + rightSum + root.val);
        maxProductUtil(root.right, sum + leftSum + root.val);
    }

    public int maxProduct(TreeNode root) {
        final int MOD = (int) 1e9 + 7;

        calculateSubtreeSum(root);
        maxProductUtil(root, 0);

        return (int) (ans % MOD);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.maxProduct(root));
    }
}
