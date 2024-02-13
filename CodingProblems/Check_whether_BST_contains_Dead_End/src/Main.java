//{ Driver Code Starts

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
class BinarySearchTree {
    public static Node root;
    BinarySearchTree() {
        root = null;
    }
    void insert(int key) {
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            BinarySearchTree obj1=new BinarySearchTree();
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                obj1.insert(b);
            }
            //inorder();
            Solution obj=new Solution();
            boolean k=obj.isDeadEnd(root);
            if(k)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}


// } Driver Code Ends


//Function should return true if a deadEnd is found in the bst otherwise return false.
class Solution {
    private HashSet<Integer> leafNodes;
    private ArrayList<Integer> allNodes;

    private void inorderTraversal(Node root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            leafNodes.add(root.data);
        }

        inorderTraversal(root.left);

        allNodes.add(root.data);

        inorderTraversal(root.right);
    }

    public boolean isDeadEnd(Node root) {
        //Add your code here.
        leafNodes = new HashSet<>();
        allNodes = new ArrayList<>();

        inorderTraversal(root);

        for (int i = 0; i < allNodes.size(); ++i) {
            int node = allNodes.get(i);
            if (leafNodes.contains(node)) {
                int left = (i > 0 ? allNodes.get(i - 1) : 0);
                int right = (i < allNodes.size() - 1 ? allNodes.get(i + 1) : Integer.MAX_VALUE);
                if (left == node - 1 && right == node + 1) {
                    return true;
                }
            }
        }

        return false;
    }
}