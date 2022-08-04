//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            ArrayList<Integer> nodes = g.ExtremeNode(root);
            for (Integer node : nodes) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;
    
    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/

class Solution {
    public  ArrayList<Integer> ExtremeNode(Node root) {
        //add code here.
        ArrayList<Integer> ans = new ArrayList<>();
        boolean firstOrLast = true;  // True means first
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            Node firstNode = null;
            Node lastNode = null;
            for (int i = 0; i < n; ++i) {
                Node node = q.poll();
                if (firstNode == null) {
                    firstNode = node;
                }
                lastNode = node;
                assert node != null;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (firstOrLast) ans.add(firstNode.data);
            else ans.add(lastNode.data);
            firstOrLast = !firstOrLast;
        }

        return ans;
    }
}