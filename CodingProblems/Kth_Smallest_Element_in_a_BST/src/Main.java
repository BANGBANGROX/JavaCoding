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
    private int idx;
    private int ans;

    private void inorderTraversal(TreeNode root, int k) {
         if (root == null) return;

         inorderTraversal(root.left, k);

         ++idx;
         if (idx == k) {
             ans = root.val;
             return;
         }

         inorderTraversal(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
       idx = 0;
       ans = 0;

       inorderTraversal(root, k);

       return ans;
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
