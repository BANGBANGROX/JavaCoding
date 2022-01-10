import java.util.Scanner;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode left;
    private int ans, length;

    private void pairSumUtil(ListNode head, int len) {
        if (head == null) return;

        pairSumUtil(head.next, len + 1);

        if (len >= length / 2) {
            ans = Math.max(ans, left.val + head.val);
            left = left.next;
        }
    }

    public int pairSum(ListNode head) {
        left = head;
        ans = 0;
        length = 0;

        ListNode tempHead = head;

        while (head != null) {
            ++length;
            head = head.next;
        }

        pairSumUtil(tempHead, 1);

        return ans;
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
