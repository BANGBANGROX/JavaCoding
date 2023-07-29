// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
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
            int k = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.findCousinSum(root, k));
            t--;

        }
    }

}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findCousinSum(Node root, int key) {
        // code here.
        int answer = 0;
        int targetLevel = -1;
        int level = 0;
        Node targetNode = null;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> siblingsMap = new HashMap<>();
        HashMap<Integer, ArrayList<Node>> levelNodeMap = new HashMap<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            levelNodeMap.put(level, new ArrayList<>());
            for (int i = 0; i < n; ++i) {
                Node currentNode = queue.poll();
                assert currentNode != null;
                if (currentNode.data == key) {
                    targetLevel = level;
                    targetNode = currentNode;
                }
                levelNodeMap.get(level).add(currentNode);
                Node leftChild = currentNode.left;
                Node rightChild = currentNode.right;
                if (leftChild != null) {
                    queue.add(leftChild);
                }
                if (rightChild != null) {
                    queue.add(rightChild);
                }
                if (leftChild != null && rightChild != null) {
                    siblingsMap.put(leftChild, rightChild);
                    siblingsMap.put(rightChild, leftChild);
                }
            }
            ++level;
        }

        // System.out.println(targetLevel);

        if (targetLevel == -1) return -1;

        for (Node node : levelNodeMap.get(targetLevel)) {
            answer += node.data;
        }

        // System.out.println(answer);

        answer -= targetNode.data;

        if (siblingsMap.containsKey(targetNode)) {
            answer -= siblingsMap.get(targetNode).data;
        }

        return answer == 0 ? -1 : answer;
    }
}
