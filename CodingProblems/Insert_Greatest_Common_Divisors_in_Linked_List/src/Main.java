import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {
    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
         ListNode current = head.next;
         ListNode previous = head;

         while (current != null) {
             ListNode next = current.next;
             int gcd = calculateGCD(current.val, previous.val);
             ListNode gcdNode = new ListNode(gcd);
             previous.next = gcdNode;
             gcdNode.next = next;
             previous = current;
             current = next;
         }

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
