import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode mergeList(ListNode l1, ListNode l2) {
       ListNode resHead = new ListNode(0);
       ListNode resTail = resHead;

       while (l1 != null && l2 != null) {
           if (l1.val < l2.val) {
               resTail.next = l1;
               l1 = l1.next;
           }
           else {
               resTail.next = l2;
               l2 = l2.next;
           }
           resTail = resTail.next;
       }

       resTail.next = (l1 == null) ? l2 : l1;

       return resHead.next;
    }

    private ListNode findMidNode(ListNode l) {
        ListNode slow = l;
        ListNode fast = l;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMidNode(head);
        ListNode next = mid.next;
        mid.next = null;

        ListNode leftList = sortList(head);
        ListNode rightList = sortList(next);

        ListNode sortedList = mergeList(leftList, rightList);

        return sortedList;
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
