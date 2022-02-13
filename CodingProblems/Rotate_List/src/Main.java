import java.util.List;
import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {
    private int findLength(ListNode head) {
        int len = 0;

        while (head != null) {
            ++len;
            head = head.next;
        }

        return len;
    }

    public ListNode rotateRight(ListNode head, int k) {
         int n = findLength(head);
         ListNode node = head;
         ListNode tempHead = head;

         if (n == 0) return null;

         k %= n;

         if (k == 0) return head;

         int ind = n - k - 1;
         int i = 0;

         while (tempHead.next != null) {
             if (i == ind) {
                 node = tempHead;
             }
             ++i;
             tempHead = tempHead.next;
         }

         ListNode next = node.next;
         node.next = null;
         tempHead.next = head;
         head = next;

         return head;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
