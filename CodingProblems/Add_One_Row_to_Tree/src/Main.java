import java.util.LinkedList;
import java.util.Queue;
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            root = newRoot;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int currentDepth = 1;

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                TreeNode currentNode = q.poll();
                assert currentNode != null;
                if (currentDepth == depth - 1) {
                    TreeNode left = currentNode.left;
                    TreeNode right = currentNode.right;
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    currentNode.left = newLeft;
                    currentNode.right = newRight;
                    newLeft.left = left;
                    newRight.right = right;
                }
                if (currentNode.left != null) q.add(currentNode.left);
                if (currentNode.right != null) q.add(currentNode.right);
            }
            ++currentDepth;
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
