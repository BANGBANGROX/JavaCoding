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
    private TreeNode findLCA(TreeNode root, int val1, int val2) {
        if (root == null || root.val == val1 || root.val == val2) return root;

        TreeNode left = findLCA(root.left, val1, val2);
        TreeNode right = findLCA(root.right, val1, val2);

        if (left == null) return right;

        if (right == null) return left;

        return root;
    }

    private StringBuilder generateStartString(TreeNode lca, int startValue) {
        if (lca == null) return null;

        if (lca.val == startValue) {
            return new StringBuilder();
        }

        StringBuilder left = generateStartString(lca.left, startValue);
        StringBuilder right = generateStartString(lca.right, startValue);

        if (left != null) return left.append('U');

        if (right != null) return right.append('U');

        return null;
    }

    private StringBuilder generateEndString(TreeNode lca, int destValue) {
        if (lca == null) return null;

        if (lca.val == destValue) {
            return new StringBuilder();
        }

        StringBuilder left = generateEndString(lca.left, destValue);
        StringBuilder right = generateEndString(lca.right, destValue);

        if (left != null) {
            return left.append('L');
        }

        if (right != null) {
            return right.append('R');
        }

        return null;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
           TreeNode lca = findLCA(root, startValue, destValue);

           StringBuilder start = generateStartString(lca, startValue);
           StringBuilder end = generateEndString(lca, destValue);

           end.reverse();

           return start.toString() + end.toString();
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
