import java.util.Scanner;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
          if (root == null) {
              root = new TreeNode(val);
          }

          if (root.val > val) {
              root.left = insertIntoBST(root.left, val);
          }

          if (root.val < val) {
              root.right = insertIntoBST(root.right, val);
          }

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
