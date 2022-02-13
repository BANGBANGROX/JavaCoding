import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tempHead = head;
        ListNode first = null;
        ListNode last = null;
        int len = 0;
        int ind = 0;

        --k;

        while (tempHead != null) {
            if (ind == k) {
                first = tempHead;
            }
            ++len;
            ++ind;
            tempHead = tempHead.next;
        }

        tempHead = head;

        k = len - k - 1;
        ind = 0;

        while (tempHead != null) {
            if (ind == k) {
                last = tempHead;
                break;
            }
            ++ind;
            tempHead = tempHead.next;
        }

        int temp = first.val;
        first.val = last.val;
        last.val = temp;

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
