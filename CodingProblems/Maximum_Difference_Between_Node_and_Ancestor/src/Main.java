import com.sun.source.tree.Tree;

import java.util.Scanner;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Solution {
    private int maxDiff;

    private void maxAncestorDiffUtil(TreeNode root, int maxVal, int minVal) {
          if (root == null) return;

          if (maxVal == Integer.MIN_VALUE && minVal == Integer.MAX_VALUE) {
              maxAncestorDiffUtil(root.left, Math.max(maxVal, root.val), Math.min(minVal, root.val));
              maxAncestorDiffUtil(root.right, Math.max(maxVal, root.val), Math.min(minVal, root.val));

              return;
          }

          maxDiff = Math.max(maxDiff, Math.max(Math.abs(maxVal - root.val), Math.abs(minVal - root.val)));

          maxAncestorDiffUtil(root.left, Math.max(maxVal, root.val), Math.min(minVal, root.val));
          maxAncestorDiffUtil(root.right, Math.max(maxVal, root.val), Math.min(minVal, root.val));
    }

    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;

        maxAncestorDiffUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return maxDiff;
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
