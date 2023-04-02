//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");

            int target = Integer.parseInt(br.readLine().trim());
            Node root = null;
            for (int i = 0; i < n; i++) {
                root = insert(root, Integer.parseInt(s[i]));
            }
            Solution g = new Solution();
            System.out.println(g.maxDifferenceBST(root, target));
            t--;
        }
    }

    public static Node insert(Node tree, int val) {
        if (tree == null) return new Node(val);

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int ans;
    private int target;

    private int minSumToLeaf(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = minSumToLeaf(root.left);
        int right = minSumToLeaf(root.right);
        int minValue = Math.min(left, right);

        return minValue == Integer.MAX_VALUE ? root.data : root.data + minValue;
    }

    private void maxDifferenceBSTUtil(Node root, int pathSum) {
        if (root == null) return;

        pathSum += root.data;

        if (root.data == target) {
            int minSum = minSumToLeaf(root);
            ans = Math.max(ans, pathSum - minSum);
            return;
        }

        if (root.data < target) {
            maxDifferenceBSTUtil(root.right, pathSum);
        }

        if (root.data > target) {
            maxDifferenceBSTUtil(root.left, pathSum);
        }
    }

    public int maxDifferenceBST(Node root, int target) {
        //Please code here
        ans = Integer.MIN_VALUE;
        this.target = target;

        maxDifferenceBSTUtil(root, 0);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}