import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode currentNode = q.poll();
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                    currentLevel.add(currentNode.left.val);
                }
                else {
                    currentLevel.add(null);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                    currentLevel.add(currentNode.right.val);
                }
                else {
                    currentLevel.add(null);
                }
            }
            int left = 0;
            int right = currentLevel.size() - 1;
            while (left < right) {
                if (currentLevel.get(left) != currentLevel.get(right)) return false;
                ++left;
                --right;
            }
        }

        return true;
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
