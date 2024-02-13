//{ Driver Code Starts

import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

}
class GFG{
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            int k = sc.nextInt();

            Solution g = new Solution();
            head = g.sortedInsert(head,k);

            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends


// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        if (key <= head.data) {
            Node node = new Node(key);
            node.next = head;
            return node;
        }

        Node current = head;
        Node node = new Node(key);

        while (current.next != null) {
            Node next = current.next;
            if (next.data >= key) {
                current.next = node;
                node.next = next;
                return head;
            }
            current = next;
        }

        current.next = node;

        return head;
    }
}