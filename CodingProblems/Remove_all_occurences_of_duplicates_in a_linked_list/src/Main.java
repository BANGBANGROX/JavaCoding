//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
class duplicates
{
    Node head;
    Node tail;
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
    }
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    /* Drier program to test above functions */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            duplicates llist = new duplicates();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }

}
// } Driver Code Ends


//User function Template for Java

/* Linked List Node class

class Node
{
    int data;
    Node next;
}
    
*/

class Solution {
    public Node removeAllDuplicates(Node head) {
        //code here
        Node current = head;
        Node resHead = new Node(-1);
        Node resTail = resHead;

        while (current != null) {
            int cnt = 1;
            while (current.next != null && current.data == current.next.data) {
                current = current.next;
                ++cnt;
            }
            Node next = current.next;
            if (cnt == 1) {
                resTail.next = current;
                resTail = resTail.next;
                resTail.next = null;
            }
            current = next;
        }

        return resHead.next;
    }
}