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
    public ListNode removeNthFromEnd(ListNode head, int n) {
          ListNode fast = head;
          ListNode slow = head;

          for (int i = 0; i < n; ++i) {
              fast = fast.next;
          }

          if (fast == null) return head.next;

          while (fast.next != null) {
              fast = fast.next;
              slow = slow.next;
          }

          slow.next = slow.next.next;

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
