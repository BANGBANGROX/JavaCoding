//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String[] s = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < n; i++) {
                copy.next = new Node(Integer.parseInt(s[i]));
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node ans = ob.modifyTheList(head);
            while (ans != null) {
                out.print(ans.data + " ");
                ans = ans.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private Node left;
    private int nodeCount;

    private Node modifyTheListHandler(Node right) {
        if (right.next == null) return right;

        Node nextNode = modifyTheListHandler(right.next);

        if (nodeCount > 0) {
            int temp = nextNode.data;
            nextNode.data = left.data;
            left.data = temp - left.data;
            left = left.next;
            --nodeCount;
        }

        return right;
    }

    public Node modifyTheList(Node head) {
        left = head;
        int length = 0;
        Node current = head;

        while (current != null) {
            ++length;
            current = current.next;
        }

        nodeCount = length / 2;

        assert head != null;

        return modifyTheListHandler(head);
    }
}