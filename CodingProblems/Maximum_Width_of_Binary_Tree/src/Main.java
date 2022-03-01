import java.util.*;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode() {
     }

     TreeNode(int val) {
         this.val = val;
     }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


class Solution {
    private static class Pair {
        TreeNode first;
        int second;

        Pair(TreeNode node, int val) {
            first = node;
            second = val;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
          int maxWidth = 0;
          Queue<Pair> q = new LinkedList<>();

          q.add(new Pair(root, 0));

          while (!q.isEmpty()) {
              int size = q.size();
              int common = q.peek().second;
              int left = 0;
              int right = 0;
              for (int i = 0; i < size; ++i) {
                  assert q.peek() != null;
                  TreeNode currentNode = q.peek().first;
                  int val = q.peek().second - common;
                  q.poll();
                  if (i == 0) left = val;
                  if (i == size - 1) right = val;
                  if (currentNode.left != null) q.add(new Pair(currentNode.left, 2 * val));
                  if (currentNode.right != null) q.add(new Pair(currentNode.right, 2 * val + 1));
              }
              maxWidth = Math.max(maxWidth, right - left + 1);
          }

          return maxWidth;
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
