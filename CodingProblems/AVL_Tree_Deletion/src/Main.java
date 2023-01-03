//{ Driver Code Starts
import java.io.*;
import java.util.*;

class pair {
    int first;
    boolean second;

    pair(int first, boolean second) {
        this.first = first;
        this.second = second;
    }
}

class Node {
    int data, height;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
        height = 1;
    }
}

class Main {
    public static int setHeights(Node n) {
        if (n == null) return 0;
        n.height = 1 + Math.max(setHeights(n.left), setHeights(n.right));
        return n.height;
    }

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

        setHeights(root);
        return root;
    }

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper);
    }

    public static pair isBalanced(Node n) {
        if (n == null) {
            return new pair(0, true);
        }

        pair l = isBalanced(n.left);
        pair r = isBalanced(n.right);

        if (Math.abs(l.first - r.first) > 1) return new pair(0, false);

        return new pair(1 + Math.max(l.first, r.first), l.second && r.second);
    }

    public static boolean isBalancedBST(Node root) {
        if (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.print("BST violated, inorder traversal : ");

        else if (!isBalanced(root).second)
            System.out.print("Unbalanced BST, inorder traversal : ");

        else return true;
        return false;
    }

    public static void printInorder(Node n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);


            int n = Integer.parseInt(br.readLine());
            int[] ip = new int[n];

            String[] in = br.readLine().trim().split("\\s+");

            for (int i = 0; i < n; i++)
                ip[i] = Integer.parseInt(in[i]);

            Sol obj = new Sol();

            for (int i = 0; i < n; i++) {
                root = obj.deleteNode(root, ip[i]);

                if (!isBalancedBST(root))
                    break;
            }

            if (root == null)
                System.out.print("null");
            else
                printInorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol {
    private int getHeight(Node node) {
        if (node == null) return 0;

        return node.height;
    }

    private int getBalancingFactor(Node node) {
        if (node == null) return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    private int updateHeight(Node node) {
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private Node leftRotation(Node node) {
        Node right = node.right;
        Node left = right.left;

        right.left = node;
        node.right = left;

        node.height = updateHeight(node);
        right.height = updateHeight(right);

        return right;
    }

    private Node rightRotation(Node node) {
        Node left = node.left;
        Node right = left.right;

        left.right = node;
        node.left = right;

        node.height = updateHeight(node);
        left.height = updateHeight(left);

        return left;
    }

    private Node findInorderSuccessor(Node node) {
        Node ans = node;

        while (ans != null && ans.left != null) ans = ans.left;

        return ans;
    }

    public Node deleteNode(Node root, int key) {
        // code here.
        if (root == null) return null;

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                Node inorderSuccessor = findInorderSuccessor(root.right);
                root.data = inorderSuccessor.data;
                root.right = deleteNode(root.right, inorderSuccessor.data);
            }
        }

        root.height = updateHeight(root);

        int balancing = getBalancingFactor(root);

        // L Case
        if (balancing > 1) {
            // LR Case
            if (getBalancingFactor(root.left) < 0) {
                root.left = leftRotation(root.left);
            }
            // LL Case
            return rightRotation(root);
        }
        // R Case
        else if (balancing < -1) {
            // RL Case
            if (getBalancingFactor(root.right) > 0) {
                root.right = rightRotation(root.right);
            }
            // RR Case
            return leftRotation(root);
        }

        return root;
    }
}