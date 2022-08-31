//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node {
    int data;
    Node next, prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for (int i = 1; i < s.length; i++) {
            tail.next = new Node(Integer.parseInt(s[i]));
            tail.next.prev = tail;
            tail = tail.next;
        }
        return head;
    }

}


class IntMatrix {

    public static void print(ArrayList<ArrayList<Integer>> m) {
        if (m.size() == 0) {
            System.out.println("-1");
        } else {
            for (var a : m) {
                System.out.print("(" + a.get(0) + "," + a.get(1) + ")" + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());


            Node head = Node.inputList(br);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findPairsWithGivenSum(target, head);

            IntMatrix.print(res);

        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node currentHead = head;
        Node currentTail = head;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (currentTail.next != null) currentTail = currentTail.next;

        while (currentHead != currentTail && currentHead != currentTail.next) {
            int sum = currentHead.data + currentTail.data;
            if (sum == target) {
                ans.add(new ArrayList<>(Arrays.asList(currentHead.data, currentTail.data)));
                currentHead = currentHead.next;
                currentTail = currentTail.prev;
            }
            else if (sum > target) currentTail = currentTail.prev;
            else currentHead = currentHead.next;
        }

        return ans;
    }
}

