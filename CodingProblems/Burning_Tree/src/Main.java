//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
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

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    private HashSet<Node> visited;
    private int ans;

    private void minTimeUtil(Node root, Node parent) {
        if (root == null) return;

        minTimeUtil(root.left, root);
        minTimeUtil(root.right, root);

        if ((parent == null && !visited.contains(root)) ||
                (!visited.contains(root.left) && !visited.contains(root.right))) {
            ++ans;
            visited.add(parent);
            visited.add(root.left);
            visited.add(root.right);
            visited.add(root);
        }
    }

    public int minTime(Node root, int target) {
        // Your code goes here
        visited = new HashSet<>();
        ans = 0;

        visited.add(null);

        minTimeUtil(root, null);

        return ans;
    }
}