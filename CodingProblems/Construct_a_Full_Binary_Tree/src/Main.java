//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] pre = new int[n];
            int[] preM = new int[n];

            for (int i = 0; i < n; i++)
                pre[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                preM[i] = sc.nextInt();

            Solution gfg = new Solution();


            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();

        }
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    private int[] preOrder;
    private int[] preOrderMirror;
    private int n;
    private int index;

    private Node constructBTreeHandler(int l, int r) {
        if (index >= n || l > r) return null;

        Node root = new Node(preOrder[index]);
        ++index;

        if (l == r || index == n) return root;

        int nextIndex = r + 1;

        for (int i = l; i <= r; ++i) {
            if (preOrder[index] == preOrderMirror[i]) {
                nextIndex = i;
                break;
            }
        }

        if (nextIndex > r) return root;

        root.left = constructBTreeHandler(nextIndex, r);
        root.right = constructBTreeHandler(l + 1, r - 1);

        return root;
    }

    public Node constructBTree(int[] preOrder, int[] preOrderMirror, int n) {
        // your code here
        this.preOrder = preOrder;
        this.preOrderMirror = preOrderMirror;
        this.n = n;
        index = 0;

        return constructBTreeHandler(0, n - 1);
    }
}