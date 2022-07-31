//{ Driver Code Starts
//Initial Template for Java


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
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
            Tree g = new Tree();
            g.printCorner(root);
            System.out.println();
        }
    }
}





// } Driver Code Ends


//User function Template for Java

/* Node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree {
    public void printCorner(Node root) {
        // add your code here
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            boolean isFirstNode = true;
            Node lastNode = null;
            Node firstNode = null;
            for (int i = 0; i < n; ++i) {
                Node current = q.poll();
                assert current != null;
                if (isFirstNode) {
                    firstNode = current;
                    isFirstNode = false;
                }
                lastNode = current;
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            if (firstNode == lastNode) {
                System.out.print(firstNode.data + " ");
            }
            else {
                System.out.print(firstNode.data + " " + lastNode.data + " ");
            }
        }
    }
}