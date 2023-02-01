//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

class Main {

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

            Solution ob = new Solution();
            System.out.println(ob.maxGCD(root));
            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    private int ans = 0;
    private int maxGCDValue = 0;

    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    private void maxGCDUtil(Node root) {
        if (root == null) return;

        maxGCDUtil(root.left);
        maxGCDUtil(root.right);

        if (root.left != null && root.right != null) {
            int gcd = calculateGCD(root.left.data, root.right.data);
            if (gcd > maxGCDValue) {
                ans = root.data;
                maxGCDValue = gcd;
            } else if (gcd == maxGCDValue) {
                ans = Math.max(ans, root.data);
            }
        }
    }

    public int maxGCD(Node root) {
        // code here
        maxGCDUtil(root);

        return ans;
    }
}

