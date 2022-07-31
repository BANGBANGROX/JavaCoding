//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

public class Main
{
    static Node head;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }

            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }

    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution {
    public static void rearrange(Node odd) {
        // add your code here
        Node currentOdd = odd;
        Node previousOdd = null;
        Node currentEven = odd.next;
        Node previousEven = null;

        while (currentOdd.next != null) {
            currentOdd.next = currentOdd.next.next;
            previousOdd = currentOdd;
            currentOdd = currentOdd.next;
            currentEven.next = previousEven;
            previousEven = currentEven;
            if (currentOdd == null || currentOdd.next == null) break;
            currentEven = currentOdd.next;
        }

        if (currentOdd != null) currentOdd.next = previousEven;
        else previousOdd.next = previousEven;
    }
}
