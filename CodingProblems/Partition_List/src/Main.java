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
    private ListNode appendNode(ListNode list, int val) {
        if (list == null) {
            list = new ListNode(val);
            return list;
        }

        list.next = new ListNode(val);
        list = list.next;

        return list;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = null;
        ListNode lesserTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        ListNode tempHead = head;

        while (tempHead != null) {
            int val = tempHead.val;
            if (val < x) {
                lesserTail = appendNode(lesserTail, val);
                if (lesserHead == null) {
                    lesserHead = lesserTail;
                }
            }
            else {
                greaterTail = appendNode(greaterTail, val);
                if (greaterHead == null) {
                    greaterHead = greaterTail;
                }
            }
            tempHead = tempHead.next;
        }

        if (lesserHead == null) return greaterHead;

        lesserTail.next = greaterHead;

        return lesserHead;
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
