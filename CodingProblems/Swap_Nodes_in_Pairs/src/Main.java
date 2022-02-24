import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
       if (head == null || head.next == null) return head;

       ListNode temp = head.next;
       head.next = temp.next;
       temp.next = head;
       head = temp;
       head.next.next = swapPairs(head.next.next);

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
