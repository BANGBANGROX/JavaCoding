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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;

        if (root1.val != root2.val) return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}

public class Main {
   public static void main(String[] args) {
       TreeNode root1 = new TreeNode(1);
       root1.left = new TreeNode(2);
       root1.right = new TreeNode(3);
       TreeNode root2 = new TreeNode(4);
       root2.left = new TreeNode(5);
       root2.right = new TreeNode(6);

       System.out.println(new Solution().flipEquiv(root1, root2));
   }
}
