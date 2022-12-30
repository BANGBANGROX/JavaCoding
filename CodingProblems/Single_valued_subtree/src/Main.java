//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Main {

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.singleValued(root));

            t--;

        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    private int ans;

    private boolean singleValuedUtil(Node root) {
        if (root == null) return true;

        boolean left = singleValuedUtil(root.left);
        boolean right = singleValuedUtil(root.right);
        boolean res = (root.left == null || root.left.data == root.data) &&
                (root.right == null || root.right.data == root.data);

        if (left && right && res) ++ans;

        return res;
    }

    public int singleValued(Node root) {
        //code here
        ans = 0;

        singleValuedUtil(root);

        return ans;
    }
}