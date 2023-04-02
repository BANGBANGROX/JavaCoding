import java.util.LinkedList;
import java.util.PriorityQueue;
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            long currentSum = 0;
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();
                assert node != null;
                currentSum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (pq.size() < k) pq.add(currentSum);
            else {
                assert pq.peek() != null;
                if (pq.peek() < currentSum) {
                    pq.poll();
                    pq.add(currentSum);
                }
            }
        }

        return pq.size() < k ? -1 : pq.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        int k = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.kthLargestLevelSum(root, k));

        sc.close();
    }
}
