// { Driver Code Starts
// driver code

import java.util.Scanner;

class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}

public class Main
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;

        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            Solution x = new Solution();
            System.out.println( x.countNodesInLoop(head) );
        }
    }
}
// } Driver Code Ends


//Function should return the length of the loop in LL.

class Solution {
    //Function to find the length of a loop in the linked list.
    public int countNodesInLoop(Node head) {
        //Add your code here.

        if (head == null || head.next == null) return 0;

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast || slow == null) return 0;

        Node start = head;

        while (start != slow) {
            start = start.next;
            assert slow != null;
            slow = slow.next;
        }

        int ans = 1;
        start = start.next;

        while (start != slow) {
            start = start.next;
            ++ans;
        }

        return ans;
    }
}