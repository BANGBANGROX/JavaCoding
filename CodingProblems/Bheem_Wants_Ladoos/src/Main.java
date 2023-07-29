//{ Driver Code Starts
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

public class Main {

    static Node buildTree(String str) {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String line = br.readLine().trim();
            Node root = buildTree(line);

            line = br.readLine().trim();
            String[] target_k = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);

            Solution x = new Solution();
            System.out.println(x.ladoos(root, home, k));
            t--;
        }
    }
}


// } Driver Code Ends


class Solution {
    private HashMap<Integer, ArrayList<Integer>> tree;
    private int answer;
    private int k;

    private void computeResult(int node, int parent, int distance) {
        if (distance < k) {
            answer += node;
        }

        for (int child : tree.get(node)) {
            if (child != parent) {
                computeResult(child, node, distance + 1);
            }
        }
    }

    private void buildTree(Node root) {
        if (root == null) return;

        if (root.left != null) {
            if (!tree.containsKey(root.data)) {
                tree.put(root.data, new ArrayList<>());
            }
            if (!tree.containsKey(root.left.data)) {
                tree.put(root.left.data, new ArrayList<>());
            }
            tree.get(root.data).add(root.left.data);
            tree.get(root.left.data).add(root.data);
            buildTree(root.left);
        }

        if (root.right != null) {
            if (!tree.containsKey(root.data)) {
                tree.put(root.data, new ArrayList<>());
            }
            if (!tree.containsKey(root.right.data)) {
                tree.put(root.right.data, new ArrayList<>());
            }
            tree.get(root.data).add(root.right.data);
            tree.get(root.right.data).add(root.data);
            buildTree(root.right);
        }
    }

    public int ladoos(Node root, int home, int k) {
        // Your code goes here
        tree = new HashMap<>();
        answer = 0;
        this.k = k;

        buildTree(root);
        computeResult(home, -1, 0);

        return answer;
    }
}

