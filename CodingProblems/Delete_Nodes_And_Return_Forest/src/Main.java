import java.util.ArrayList;
import java.util.HashSet;
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
    private final List<TreeNode> ans = new ArrayList<>();

    private TreeNode deleteNode(TreeNode root, HashSet<Integer> toDelete) {
        if (root == null) return null;

        TreeNode left = deleteNode(root.left, toDelete);
        TreeNode right = deleteNode(root.right, toDelete);

        if (toDelete.contains(root.val)) {
            if (left != null) ans.add(left);
            if (right != null) ans.add(right);

            return null;
        }

        root.left = left;
        root.right = right;

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
       HashSet<Integer> toDelete = new HashSet<>();

       for (int x: to_delete) {
           toDelete.add(x);
       }

       root = deleteNode(root, toDelete);

        if (root != null) {
            ans.add(root);
        }

       return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);
        int[] to_delete = new int[]{5, 10};

        Solution solution = new Solution();
        System.out.println(solution.delNodes(root, to_delete));
    }
}
