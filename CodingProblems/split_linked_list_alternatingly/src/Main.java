//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.getFirst());
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    public Node[] alternatingSplitList(Node head) {
        // code here
        Node firstHead = new Node(-1);
        Node firstTail = firstHead;
        Node secondHead = new Node(-1);
        Node secondTail = secondHead;
        Node current = head;
        boolean flag = true;

        while (current != null) {
            Node next = current.next;
            if (flag) {
                firstTail.next = current;
                firstTail = firstTail.next;
            } else {
                secondTail.next = current;
                secondTail = secondTail.next;
            }
            current.next = null;
            flag = !flag;
            current = next;
        }

        return new Node[]{firstHead.next, secondHead.next};
    }
}