//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Main {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution {
    private Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node res = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

    private int findLength(Node head) {
        int ans = 0;

        while (head != null) {
            ++ans;
            head = head.next;
        }

        return ans;
    }

    public Node subLinkedList(Node l1, Node l2) {
        // code here
        while (l1 != null && l1.data == 0) {
            l1 = l1.next;
        }

        while (l2 != null && l2.data == 0) {
            l2 = l2.next;
        }

        if (l1 == null) return l2;

        if (l2 == null) return l1;

        Node temp1 = l1;
        Node temp2 = l2;
        int length1 = findLength(temp1);
        int length2 = findLength(temp2);
        boolean equalLengthFirstGreater = false;

        if (length1 == length2) {
            while (temp1 != null && temp2 != null) {
                if (temp1.data != temp2.data) break;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            if (temp1 == null || temp2 == null) return new Node(0);
            if (temp1.data > temp2.data) equalLengthFirstGreater = true;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        if (length1 == length2) {
            if (equalLengthFirstGreater) {
                temp1 = l1;
                temp2 = l2;
            }
            else {
                temp1 = l2;
                temp2 = l1;
            }
        }

        if (length1 > length2) {
            temp1 = l1;
            temp2 = l2;
        }

        if (length2 > length1) {
            temp1 = l2;
            temp2 = l1;
        }

        int carry = 0;

        while (temp1 != null && temp2 != null) {
            temp1.data = temp1.data - carry;
            if (temp1.data < temp2.data) {
                temp1.data = temp1.data + 10 - temp2.data;
                carry = 1;
            } else {
                temp1.data = temp1.data - temp2.data;
                carry = 0;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            if (carry > 0) {
                if (temp1.data < carry) {
                    temp1.data = temp1.data + 10 - carry;
                }
                else {
                    temp1.data = temp1.data - carry;
                    carry = 0;
                }
            }
            temp1 = temp1.next;
        }

        Node ans = null;

        if (length1 > length2) ans = reverseList(l1);
        if (length1 < length2) ans = reverseList(l2);
        if (length1 == length2) {
            if (equalLengthFirstGreater) ans = reverseList(l1);
            else ans = reverseList(l2);
        }

        while (ans != null && ans.data == 0) ans = ans.next;

        if (ans == null) ans = new Node(0);

        return ans;
    }
}