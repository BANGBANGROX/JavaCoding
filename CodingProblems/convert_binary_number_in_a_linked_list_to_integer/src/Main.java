import java.util.Scanner;

class ListNode {
    final int val;
    ListNode next;

    public ListNode(final int val) {
        this.val = val;
    }
}

class Solution {
    public int getDecimalValue(final ListNode head) {
        ListNode current = head;
        int answer = 0;

        while (current != null) {
            answer = answer * 2 + current.val;
            current = current.next;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final ListNode head = new ListNode(-1);
           ListNode tail = head;

           for (int i = 0; i < n; ++i) {
               tail.next = new ListNode(scanner.nextInt());
               tail = tail.next;
           }

           System.out.println(new Solution().getDecimalValue(head.next));
       }
       
       scanner.close();
   }
}
