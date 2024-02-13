import java.util.ArrayList;

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
    private int currentNumCnt;
    private int maxCnt;
    private int previousNum;
    private ArrayList<Integer> modes;

    private void findMaxCount(TreeNode root) {
        if (root == null) {
            return;
        }

        findMaxCount(root.left);

        if (root.val == previousNum) {
            ++currentNumCnt;
        } else {
            currentNumCnt = 1;
            previousNum = root.val;
        }
        maxCnt = Math.max(maxCnt, currentNumCnt);

        findMaxCount(root.right);
    }

    private void findModes(TreeNode root) {
        if (root == null) {
            return;
        }

        findModes(root.left);

        if (root.val == previousNum) {
            ++currentNumCnt;
        } else {
            currentNumCnt = 1;
            previousNum = root.val;
        }
        if (currentNumCnt == maxCnt) {
            modes.add(root.val);
        }

        findModes(root.right);
    }

    public int[] findMode(TreeNode root) {
        previousNum = Integer.MAX_VALUE;
        maxCnt = 1;
        modes = new ArrayList<>();

        findMaxCount(root);

        currentNumCnt = 1;
        previousNum = Integer.MAX_VALUE;

        findModes(root);

        return modes.stream().mapToInt(x -> x).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(9);

        Solution solution = new Solution();
        int[] answer = solution.findMode(root);
        for (int x : answer) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
