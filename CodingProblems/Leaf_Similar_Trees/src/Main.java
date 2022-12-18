import java.util.ArrayList;

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
    private void getLeafList(TreeNode root, ArrayList<Integer> leaves) {
        if (root == null) return;

        if (root.left == null && root.right == null) leaves.add(root.val);

        getLeafList(root.left, leaves);
        getLeafList(root.right, leaves);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leavesOfRoot1 = new ArrayList<>();
        ArrayList<Integer> leavesOfRoot2 = new ArrayList<>();

        getLeafList(root1, leavesOfRoot1);
        getLeafList(root2, leavesOfRoot2);

        return leavesOfRoot1.equals(leavesOfRoot2);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.leafSimilar(root1, root2));
    }
}
