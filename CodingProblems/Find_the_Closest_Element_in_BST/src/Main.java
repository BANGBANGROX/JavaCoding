//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

public class Main {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0)
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine().trim());

            Solution T = new Solution();
            System.out.println(T.minDiff(root, k));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int answer;
    private int k;

    private void dfs(Node root) {
        if (root == null) return;

        int difference = k - root.data;

        if (difference > 0) {
            answer = Math.min(answer, difference);
            dfs(root.right);
        }
        else {
            answer = Math.min(answer, -1 * difference);
            dfs(root.left);
        }
    }

    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    public int minDiff(Node root, int k) {
        // Write your code here
        this.k = k;
        answer = Integer.MAX_VALUE;

        dfs(root);

        return answer;
    }
}

