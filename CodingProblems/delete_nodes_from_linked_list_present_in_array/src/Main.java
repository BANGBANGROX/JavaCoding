import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numsSet = new HashSet<>();
        ListNode answerHead = new ListNode(-1);
        ListNode answerTail = answerHead;

        for (int num : nums) {
            numsSet.add(num);
        }

        for (ListNode current = head; current != null; current = current.next) {
            if (!numsSet.contains(current.val)) {
                answerTail.next = new ListNode(current.val);
                answerTail = answerTail.next;
            }
        }

        return answerHead.next;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();

       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int numsInList = scanner.nextInt();
           ListNode head = new ListNode(-1);
           ListNode tail = head;
           for (int i = 0; i < numsInList; ++i) {
               tail.next = new ListNode(scanner.nextInt());
               tail = tail.next;
           }

           ListNode answer = new Solution().modifiedList(nums, head.next);
           for (ListNode current = answer; current != null; current = current.next) {
               System.out.print(current.val + " ");
           }
           System.out.println();
       }

       scanner.close();
   }
}
