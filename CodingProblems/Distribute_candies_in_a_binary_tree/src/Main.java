//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

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
    public static Node buildTree(String str) {

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
            if (i >= ip.length) break;

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


    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            System.out.println(ob.distributeCandy(root));

        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    private int ans;

    private void distributeCandyUtil(Node root) {
        if (root == null) return;

        distributeCandyUtil(root.left);
        distributeCandyUtil(root.right);

        if (root.left != null && root.left.data != 1) {
            if (root.left.data < 1) {
                int take = 1 - root.left.data;
                root.data -= take;
                root.left.data += take;
                ans += take;
            }
            else {
                int put = root.left.data - 1;
                root.data += put;
                root.left.data -= put;
                ans += put;
            }
        }

        if (root.right != null && root.right.data != 1) {
            if (root.right.data < 1) {
                int put = 1 - root.right.data;
                root.data -= put;
                root.right.data += put;
                ans += put;
            }
            else {
                int take = root.right.data - 1;
                root.data += take;
                root.right.data -= take;
                ans += take;
            }
        }
    }

    public int distributeCandy(Node root) {
        //code here
        ans = 0;

        distributeCandyUtil(root);

        return ans;
    }
}