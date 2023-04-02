//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node.printList(node, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node);
*/

class Solution {
    private boolean check(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i) {
            if (count1[i] != count2[i]) return false;
        }

        return true;
    }

    public ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        StringBuilder text = new StringBuilder();
        Node current = head;
        ArrayList<Node> ans = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            ++count1[ch - 'a'];
        }

        while (current != null) {
            text.append(current.data);
            current = current.next;
        }

        int m = text.length();
        int n = s.length();

        if (n > m) return ans;

        int l = 0;
        int r = n - 1;

        for (int i = l; i <= r; ++i) {
            ++count2[text.charAt(i) - 'a'];
        }

        while (r < m) {
            if (check(count1, count2)) {
                indices.add(l);
            }
            --count2[text.charAt(l) - 'a'];
            ++l;
            ++r;
            if (r < m) ++count2[text.charAt(r) - 'a'];
        }

        if (indices.isEmpty()) return ans;

        int idx = 0;
        int prev = indices.get(0);
        current = head;
        HashSet<Integer> filteredIndices = new HashSet<>();

        filteredIndices.add(indices.get(0));

        for (int i = 1; i < indices.size(); ++i) {
            if (indices.get(i) - prev < n) continue;
            filteredIndices.add(indices.get(i));
            prev = indices.get(i);
        }

        while (current != null) {
            if (filteredIndices.contains(idx)) {
                Node temp = current;
                ans.add(temp);
                for (int i = 1; i < n; ++i) {
                    current = current.next;
                }
                Node next = current.next;
                current.next = null;
                current = next;
                idx += n;
            }
            else {
                current = current.next;
                ++idx;
            }
        }

        return ans;
    }
}