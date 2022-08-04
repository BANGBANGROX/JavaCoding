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
    private int index;

    private int findIndex(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; ++i) {
            if (inorder[i] == key) return i;
        }

        return -1;
    }

    private TreeNode buildTreeUtil(int[] inorder, int[] postorder, int start, int end) {
        if (start > end || index < 0) return null;

        TreeNode root = new TreeNode(postorder[index]);
        --index;

        int idx = findIndex(inorder, start, end, root.val);

        root.right = buildTreeUtil(inorder, postorder, idx + 1, end);
        root.left = buildTreeUtil(inorder, postorder, start, idx - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
          int n = inorder.length;
          index = n - 1;

          return buildTreeUtil(inorder, postorder, 0, n - 1);
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
