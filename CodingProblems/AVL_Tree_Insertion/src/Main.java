//{ Driver Code Starts

import java.util.Scanner;

class pair {
    int first;
    boolean second;

    pair(int first, boolean second) {
        this.first = first;
        this.second = second;
    }
}

class Node {
    int data, height;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
        height = 1;
    }
}

public class Main {
    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    public static pair isBalanced(Node n) {
        if (n == null) {
            return new pair(0, true);
        }

        pair l = isBalanced(n.left);
        pair r = isBalanced(n.right);

        if (Math.abs(l.first - r.first) > 1) return new pair(0, false);

        return new pair(1 + Math.max(l.first, r.first), l.second && r.second);
    }

    public static boolean isBalancedBST(Node root) {
        if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.print("BST violated, inorder traversal : ");

        else if (!isBalanced(root).second)
            System.out.print("Unbalanced BST, inorder traversal : ");

        else return true;
        return false;
    }

    public static void printInorder(Node n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }


    public static void main(String[] args) {
        int[] ip = new int[2000];
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                ip[i] = sc.nextInt();
            }

            Node root = null;
            Solution obj = new Solution();
            for (int i = 0; i < n; i++) {
                root = obj.insertToAVL(root, ip[i]);

                if (!isBalancedBST(root))
                    break;
            }

            printInorder(root);
            System.out.println();

        }


    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int getHeight(Node node) {
        if (node == null) return 0;

        return node.height;
    }

    private int getBalancingFactor(Node node) {
        if (node == null) return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        Node left = right.left;

        right.left = node;
        node.right = left;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;

        return right;
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        Node right = left.right;

        left.right = node;
        node.left = right;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;

        return left;
    }

    public Node insertToAVL(Node node, int data) {
        //code here
        if (node == null) return new Node(data);

        if (data > node.data) node.right = insertToAVL(node.right, data);
        else if (data < node.data) node.left = insertToAVL(node.left, data);
        else return node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balancing = getBalancingFactor(node);

        // LL case
        if (balancing > 1 && data < node.left.data) return rightRotate(node);

        // RR case
        if (balancing < -1 && data > node.right.data) return leftRotate(node);

        // LR case
        if (balancing > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL case
        if (balancing < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
}