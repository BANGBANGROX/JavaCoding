import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> siblingValue = new HashMap<>();
        List<TreeNode> previousLevel = new ArrayList<>();
        int lastLevelSum = root.val;

        q.add(root);
        previousLevel.add(root);

        while (!q.isEmpty()) {
            for (TreeNode node : previousLevel) {
                node.val = lastLevelSum - node.val - siblingValue.getOrDefault(node, 0);
            }
            int n = q.size();
            int currentLevelSum = 0;
            List<TreeNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();
                assert node != null;
                if (node.left != null) {
                    q.add(node.left);
                    currentLevelSum += node.left.val;
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                    currentLevelSum += node.right.val;
                    nextLevel.add(node.right);
                }
                if (node.left != null && node.right != null) {
                    siblingValue.put(node.left, node.right.val);
                    siblingValue.put(node.left, node.right.val);
                    siblingValue.put(node.right, node.left.val);
                }
            }
            lastLevelSum = currentLevelSum;
            previousLevel = nextLevel;
        }

        return root;
    }
}

public class Main {
   private static void print(TreeNode root) {
       if (root == null) return;

       System.out.print(root.val + " ");

       print(root.left);
       print(root.right);
   }

   public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);

       TreeNode answer = new Solution().replaceValueInTree(root);
       print(answer);
   }
}
