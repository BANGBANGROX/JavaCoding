// { Driver Code Starts
//Initial Template for Java

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

class GFG {

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
    static void printInorder(Node root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            Node head = g.convertToDLL(root);
            printInorder(root);
            System.out.println();
            Node curr = head;
            Node last = head;
            while(curr!=null){
                System.out.print(curr.data+" ");
                last = curr;
                curr = curr.right;
            }
            System.out.println();
            curr = last;
            while(curr!=null){
                System.out.print(curr.data+" ");
                curr = curr.left;
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
Node is as follows:
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
*/

class Tree {
    private Node dllHead;
    private Node dllTail;

    private Node appendNode(Node list, int val) {
        if (list == null) {
            list = new Node(val);
            return list;
        }

        list.right = new Node(val);
        list.right.left = list;
        list = list.right;

        return list;
    }

    private void convertToDLLUtil(Node current, Node previous, boolean parity) {
        if (current == null) return;

        if (current.left == null && current.right == null) {
            dllTail = appendNode(dllTail, current.data);
            if (dllHead == null) {
                dllHead = dllTail;
            }
            if (previous != null) {
                if (parity) {
                    previous.left = null;
                }
                else {
                    previous.right = null;
                }
            }
            return;
        }

        convertToDLLUtil(current.left, current, true);
        convertToDLLUtil(current.right, current, false);
    }

    // return the head of the DLL and remove those nodes from the tree as well.
    public Node convertToDLL(Node root) {
        // Code here
        dllHead = dllTail = null;

        convertToDLLUtil(root, null, false);

        return dllHead;
    }

}


