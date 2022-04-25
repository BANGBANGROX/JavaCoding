import java.util.Scanner;

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
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
         if (root == null) return null;

         convertBST(root.right);

         sum += root.val;
         root.val = sum;

         convertBST(root.left);

         return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
