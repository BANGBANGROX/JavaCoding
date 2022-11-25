//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
class pair
{
    int first;
    int second;
    pair(int first , int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class Main {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null)
            return true;
        if (n.data <= lower || n.data >= upper)
            return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }


        return (compare(a.left, b.left, mismatch) && compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution ob = new Solution();

            Node temp = ob.correctBST(root);
            if (temp != root)
                System.out.println(0);

            // check 1: is tree now a BST
            if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                System.out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree


            ArrayList<pair> mismatch = new ArrayList<>();
            // an arraylist to store data of mismatching nodes

            if (!compare(root, duplicate, mismatch)) {
                // false output from this function indicates change in structure of tree
                System.out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 || mismatch.get(0).first != mismatch.get(1).second || mismatch.get(0).second != mismatch.get(1).first)
                System.out.println(0);
            else
                System.out.println(1);


        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    private Node previousNode;
    private Node firstNode;
    private Node secondNode;

    private void correctBSTUtil(Node root) {
        if (root == null) return;

        correctBSTUtil(root.left);

        if (previousNode != null && root.data < previousNode.data) {
            if (firstNode == null) {
                firstNode = previousNode;
            }
            secondNode = root;
        }

        previousNode = root;

        correctBSTUtil(root.right);
    }

    //Function to fix a given BST where two nodes are swapped.
    public Node correctBST(Node root) {
        //code here.
        previousNode = firstNode = secondNode = null;

        correctBSTUtil(root);

        if (firstNode != null) {
            int temp = firstNode.data;
            firstNode.data = secondNode.data;
            secondNode.data = temp;
        }

        return root;
    }
}
