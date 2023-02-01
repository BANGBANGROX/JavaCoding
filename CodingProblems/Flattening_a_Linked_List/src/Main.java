//{ Driver Code Starts

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}


public class Main {
    Node head;

    void printList(Node node) {
        //Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Main list = new Main();
        while (t > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp;
            Node tempB;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                } else {
                    pre.next = temp;
                    pre = temp;
                }
                flag1 = 1;

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG {
    private Node mergeList(Node l1, Node l2) {
        Node resHead = new Node(-1);
        Node resTail = resHead;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                resTail.bottom = l1;
                l1 = l1.bottom;
            }
            else {
                resTail.bottom = l2;
                l2 = l2.bottom;
            }
            resTail = resTail.bottom;
        }

        resTail.bottom = l1 == null ? l2 : l1;

        return resHead.bottom;
    }

    public Node flatten(Node root) {
        // Your code here
        Node ans = root;
        Node next = root.next;

        while (next != null) {
            ans = mergeList(ans, next);
            next = next.next;
        }

        return ans;
    }
}