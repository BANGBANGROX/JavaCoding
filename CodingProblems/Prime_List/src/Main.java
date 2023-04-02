//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n;
            n = Integer.parseInt(in.readLine());
            Node head, tail;
            String[] s = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < n; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   private final ArrayList<Integer> primeNums = new ArrayList<>();

   private void init() {
       final int MAX_N = 100005;
       boolean[] prime = new boolean[MAX_N];

       Arrays.fill(prime, true);

       prime[0] = prime[1] = false;

       for (int i = 2; i < MAX_N; ++i) {
           if (prime[i]) {
               primeNums.add(i);
               for (int j = 2 * i; j < MAX_N; j += i) {
                   prime[j] = false;
               }
           }
       }
   }

   private int lowerBound(int key) {
       int n = primeNums.size();
       int l = 0;
       int r = n - 1;

       while (l <= r) {
           int mid = (l + ((r - l) >> 1));
           if (primeNums.get(mid) < key) l = mid + 1;
           else r = mid - 1;
       }

       return l;
   }

   public Node primeList(Node head) {
       //code here
       init();

       Node current = head;

       while (current != null) {
           int val = current.val;
           int idx = lowerBound(val);
           int diff = primeNums.get(idx) - val;
           current.val = primeNums.get(idx);
           if (idx > 0) {
               if (val - primeNums.get(idx - 1) < diff) {
                   current.val = primeNums.get(idx - 1);
               }
           }
           current = current.next;
       }

       return head;
   }
}