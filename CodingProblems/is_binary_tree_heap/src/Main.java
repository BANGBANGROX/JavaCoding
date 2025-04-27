//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    static Node buildTree(String str) {

        if (str.isEmpty() || str.charAt(0) == 'N') {
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
        while (!queue.isEmpty() && i < ip.length) {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    private static class Pair {
        Node node;
        int idx;

        public Pair(final Node node, final int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public boolean isHeap(Node tree) {
        // code here
        return isBinaryTreeComplete(tree) && isHeapHandler(tree);
    }

    private boolean isBinaryTreeComplete(final Node tree) {
        if (tree == null) return true;

        final Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(tree, 0));

        while (!queue.isEmpty()) {
            int n = queue.size();
            final List<Integer> nextLevelIdx = new ArrayList<>();
            int minIdx = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                final Pair pair = queue.poll();
                assert pair != null;
                final Node node = pair.node;
                final int idx = pair.idx;
                minIdx = Math.min(minIdx, idx);
                if (node.left != null) {
                    queue.add(new Pair(node.left, idx * 2 + 1));
                    nextLevelIdx.add(idx * 2 + 1);
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, idx * 2 + 2));
                    nextLevelIdx.add(idx * 2 + 2);
                }
            }
            if (!nextLevelIdx.isEmpty() && nextLevelIdx.getFirst() != 2 * minIdx + 1) {
                return false;
            }
            for (int i = 1; i < nextLevelIdx.size(); ++i) {
                if (nextLevelIdx.get(i) != nextLevelIdx.get(i - 1) + 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isHeapHandler(Node tree) {
        if (tree == null) return true;

        if (tree.left != null && tree.data < tree.left.data) return false;
        if (tree.right != null && tree.data < tree.right.data) return false;

        return isHeapHandler(tree.left) && isHeapHandler(tree.right);
    }
}