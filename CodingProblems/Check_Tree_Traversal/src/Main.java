//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] preorder = new int[n];
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++)
                preorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                postorder[i] = sc.nextInt();
            Solution ob = new Solution();
            if (ob.checkTree(preorder, inorder, postorder, n))
                System.out.println("Yes");
            else
                System.out.println("No");
            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    private int idx = 0;

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private int getIndex(int[] nums, int key, int left, int right) {
        for (int i = left; i <= right; ++i) {
            if (nums[i] == key) return i;
        }

        return -1;
    }

    private Node buildTree(int left, int right, int[] preorder, int[] inorder, int n) {
        if (idx >= n || left > right) return null;

        Node node = new Node(preorder[idx]);
        int index = getIndex(inorder, preorder[idx], left, right);
        ++idx;

        node.left = buildTree(left, index - 1, preorder, inorder, n);
        node.right = buildTree(index + 1, right, preorder, inorder, n);

        return node;
    }

    private boolean checkPostorder(Node node, int[] postorder) {
        if (node == null) return true;

        boolean result = checkPostorder(node.left, postorder) &&
                checkPostorder(node.right, postorder) && postorder[idx] == node.val;

        if (!result) return false;

        ++idx;

        return true;
    }

    public boolean checkTree(int[] preorder, int[] inorder, int[] postorder, int n) {
        // Your code goes here
        Node node = buildTree(0, n - 1, preorder, inorder, n);
        idx = 0;

        return checkPostorder(node, postorder);
    }
}