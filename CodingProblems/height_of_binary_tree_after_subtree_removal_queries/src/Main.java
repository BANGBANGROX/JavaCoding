import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Integer> maxHeightAfterRemoval;
    private int currentMaxHeight;

    private void traverseLeftToRight(TreeNode root, int currentHeight) {
        if (root == null) return;

        maxHeightAfterRemoval.put(root.val, currentMaxHeight);
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);

        traverseLeftToRight(root.left, currentHeight + 1);
        traverseLeftToRight(root.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode root, int currentHeight) {
        if (root == null) return;

        maxHeightAfterRemoval.put(root.val,
                Math.max(maxHeightAfterRemoval.get(root.val), currentMaxHeight));
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);

        traverseRightToLeft(root.right, currentHeight + 1);
        traverseRightToLeft(root.left, currentHeight + 1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        currentMaxHeight = 0;
        maxHeightAfterRemoval = new HashMap<>();
        traverseLeftToRight(root, 0);

        currentMaxHeight = 0;
        traverseRightToLeft(root, 0);

        int q = queries.length;
        int[] answer = new int[q];

        for (int i = 0; i < q; ++i) {
            answer[i] = maxHeightAfterRemoval.get(queries[i]);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       int[] queries = new int[]{2, 3};

       int[] answer = new Solution().treeQueries(root, queries);
       for (int x : answer) {
           System.out.print(x + " ");
       }
   }
}
