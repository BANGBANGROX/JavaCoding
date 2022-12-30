//{ Driver Code Starts
import java.io.*;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

public class Main {
    Node head;

    /* Function to print linked list */
    void printList(Node head, PrintWriter out) {
        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
        out.println();
    }


    /* Drier program to test above functions */
    public static void main(String[] args) throws IOException {
       
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        // Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
// 		int t=sc.nextInt();
        int t = Integer.parseInt(in.readLine().trim());

        while (t > 0) {
// 			int n = sc.nextInt();
            int n = Integer.parseInt(in.readLine().trim());
            Main llist = new Main();
            String[] s = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node temp = head;
            for (int i = 1; i < n; i++) {
                // int a = sc.nextInt();
                int a = Integer.parseInt(s[i]);
                temp.next = new Node(a);
                temp = temp.next;
            }

            Solution gfgobj = new Solution();
            llist.head = gfgobj.sortList(head);
            llist.printList(llist.head, out);

            t--;
        }
        out.close();
    }
}
// } Driver Code Ends


/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
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

    public Node sortList(Node head) {
        // Your code here
        Node positiveHead = new Node(-1);
        Node positiveTail = positiveHead;
        Node negativeHead = new Node(-1);
        Node negativeTail = negativeHead;
        Node current = head;

        while (current != null) {
            if (current.data < 0) {
                negativeTail.next = current;
                negativeTail = negativeTail.next;
            }
            else {
                positiveTail.next = current;
                positiveTail = positiveTail.next;
            }
            current = current.next;
        }

        negativeTail.next = positiveTail.next = null;

        negativeHead = reverseList(negativeHead.next);

        if (negativeHead == null) return positiveHead.next;

        Node tail = negativeHead;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = positiveHead.next;

        return negativeHead;
    }
}