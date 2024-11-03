//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String[] str = read.readLine().trim().split(" ");
            for (String s : str) {
                head = insert(head, Integer.parseInt(s));
            }
            boolean f = new Solution().isLengthEven(head);

            System.out.println(f ? "true" : "false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isLengthEven(Node head) {
        // code here
        boolean answer = true;

        for (Node current = head; current != null; current = current.next) {
            answer = !answer;
        }

        return answer;
    }
}
