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
    private int distributeCoinsHandler(TreeNode root, TreeNode parent) {
        if (root == null) return 0;

        int left = distributeCoinsHandler(root.left, root);
        int right = distributeCoinsHandler(root.right, root);
        int coins = root.val - 1;

        if (parent != null) {
            parent.val += coins;
        }

        return left + right + Math.abs(coins);
    }

    public int distributeCoins(TreeNode root) {
        return distributeCoinsHandler(root, null);
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
