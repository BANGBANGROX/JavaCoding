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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCriticalPoint = -1;
        int lastCriticalPoint = -1;
        int previousCriticalPoint = -1;
        int previousValue = head.val;
        int itr = 0;
        int[] answer = new int[2];

        answer[0] = Integer.MAX_VALUE;

        for (ListNode current = head.next; current != null && current.next != null; current = current.next, ++itr) {
            int currentValue = current.val;
            int nextValue = current.next.val;
            if ((currentValue < previousValue && currentValue < nextValue) || (currentValue > previousValue && currentValue > nextValue)) {
               if (firstCriticalPoint == -1) {
                   firstCriticalPoint = itr;
               }
               if (previousCriticalPoint != -1) {
                   answer[0] = Math.min(answer[0], itr - previousCriticalPoint);
               }
               lastCriticalPoint = itr;
               previousCriticalPoint = lastCriticalPoint;
            }
            previousValue = currentValue;
        }

        if (lastCriticalPoint == firstCriticalPoint) return new int[]{-1, -1};

        answer[1] = lastCriticalPoint - firstCriticalPoint;

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            for (int i = 0; i < n; ++i) {
                tail.next = new ListNode(scanner.nextInt());
                tail = tail.next;
            }

            int[] answer = new Solution().nodesBetweenCriticalPoints(head.next);
            System.out.println(answer[0] + " " + answer[1]);
        }

        scanner.close();
    }
}
