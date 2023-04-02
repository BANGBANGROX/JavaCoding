import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private List<TreeNode> ans;
    private HashMap<String, Integer> count;

    private String findDuplicateSubtreesUtil(TreeNode root) {
        if (root == null) return "";

        String current = '(' + findDuplicateSubtreesUtil(root.left) + ')' + root.val
                + '(' + findDuplicateSubtreesUtil(root.right) + ')';

        count.put(current, count.getOrDefault(current, 0) + 1);

        if (count.get(current) == 2) {
            ans.add(root);
        }

        return current;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        count = new HashMap<>();

        findDuplicateSubtreesUtil(root);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.findDuplicateSubtrees(root));
    }
}
