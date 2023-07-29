//{ Driver Code Starts
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

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
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

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int answer;
    private int target;

    private boolean checkBST(Node root, int minValue, int maxValue) {
        if (root == null) return true;

        return root.data > minValue && root.data < maxValue &&
                checkBST(root.left, minValue, root.data) &&
                checkBST(root.right, root.data, maxValue);
    }

    private int[] findSum(Node root) {
        if (root == null) return new int[]{0,0};

        int[] left = findSum(root.left);
        int[] right = findSum(root.right);
        int leftHeight = left[0];
        int rightHeight = right[0];
        int leftSum = left[1];
        int rightSum = right[1];
        int totalSum = leftSum + rightSum + root.data;
        int height = leftHeight + rightHeight + 1;

        if (totalSum == target && checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            answer = Math.min(answer, height);
        }

        return new int[]{height, totalSum};
    }

    public int minSubtreeSumBST(int target, Node root) {
        // code here
        answer = Integer.MAX_VALUE;
        this.target = target;

        findSum(root);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
