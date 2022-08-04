//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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

public class Main
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0)
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currrNode = q.remove();

            // Get the currrent node's value from the string
            String currrVal = s[i];

            // If the left child is not null
            if(!currrVal.equals("N"))
            {

                // Create the left child for the currrent node
                currrNode.left = new Node(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currrVal = s[i];

            // If the right child is not null
            if(!currrVal.equals("N"))
            {

                // Create the right child for the currrent node
                currrNode.right = new Node(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine().trim());

            Solution T = new Solution();
            System.out.println(T.printKDistantfromLeaf(root,k));
            t--;
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    private int k;
    private int ans;
    private HashMap<Integer, Boolean> mp;

    private void printKDistantFromLeafUtil(Node root, int h) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (k > h) return;
            if (mp.get(h - k)) {
                mp.put(h - k, false);
                ++ans;
            }
        }

        mp.put(h, true);

        printKDistantFromLeafUtil(root.left, h + 1);
        printKDistantFromLeafUtil(root.right, h + 1);
    }

    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node root, int k) {
        // Write your code here
        this.k = k;
        ans = 0;
        mp = new HashMap<>();

        printKDistantFromLeafUtil(root, 0);

        return ans;
    }

}
