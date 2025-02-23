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
    private int postIndex;
    private int preIndex;
    private int[] preorder;
    private int[] postorder;

    private TreeNode build() {
        TreeNode root = new TreeNode(preorder[preIndex]);
        ++preIndex;

        if (root.val != postorder[postIndex]) {
            root.left = build();
        }

        if (root.val != postorder[postIndex]) {
            root.right = build();
        }

        ++postIndex;

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIndex = 0;
        postIndex = 0;
        this.preorder = preorder;
        this.postorder = postorder;

        return build();
    }
}

public class Main {
   private static void printPreorder(TreeNode root) {
       if (root == null) return;

       System.out.print(root.val + " ");

       printPreorder(root.left);
       printPreorder(root.right);
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();

       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] preorder = new int[n];
           for (int i = 0; i < n; ++i) {
               preorder[i] = scanner.nextInt();
           }
           int[] postorder = new int[n];
           for (int i = 0; i < n; ++i) {
               postorder[i] = scanner.nextInt();
           }

           printPreorder(new Solution().constructFromPrePost(preorder, postorder));
       }

       scanner.close();
   }
}
