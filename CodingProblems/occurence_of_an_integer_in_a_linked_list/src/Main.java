//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
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
// complete the below function
class Solution {
    public int count(Node head, int key) {
        // code here
        int answer = 0;

        for (Node current = head; current != null; current = current.next) {
            if (current.data == key) {
                ++answer;
            }
        }

        return answer;
    }
}

//{ Driver Code Starts.

class LinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Node head = new Node(arr.getFirst());
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            int key = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(head, key));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends