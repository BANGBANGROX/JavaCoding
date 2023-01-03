//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG {
    private Node insertIntoBST(Node root, int key) {
        if (root == null) return new Node(key);

        if (root.data > key) root.left = insertIntoBST(root.left, key);
        else root.right = insertIntoBST(root.right, key);

        return root;
    }

    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] nums) {
        //Write your code here
        Node root = new Node(nums[0]);
        int n = nums.length;

        for (int i = 1; i < n; ++i) {
            root = insertIntoBST(root, nums[i]);
        }

        return root;
    }
}