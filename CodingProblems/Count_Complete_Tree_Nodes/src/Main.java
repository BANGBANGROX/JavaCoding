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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;
        int height = 1;

        while (left != null && right != null) {
            left = left.left;
            right = right.right;
            ++height;
        }

        return left == null && right == null ? (1 << height) - 1 :
                1 + countNodes(root.left) + countNodes(root.right);
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
