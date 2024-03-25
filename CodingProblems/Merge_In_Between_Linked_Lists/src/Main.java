import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode nodeBeforeA = null;
        ListNode nodeAfterB = null;
        ListNode currentNode = list1;
        ListNode previousNode = null;
        ListNode list2LastNode = list2;

        while (currentNode != null) {
            if (idx == a) {
                nodeBeforeA = previousNode;
            }
            if (idx == b) {
                nodeAfterB = currentNode.next;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            ++idx;
        }

        while (list2LastNode.next != null) {
            list2LastNode = list2LastNode.next;
        }

        // CASE 1 : When a is 0 -> a == 0
        if (a == 0) {
            // CASE 1.1 : When b is 0 -> b == 0
            if (b == 0) {
                list2LastNode.next = list1.next;
                return list2;
            }
            // CASE 1.2 : When b is the last Node -> b == idx - 1
            else if (b == idx - 1) {
                return list2;
            }
            // CASE 1.3 : When b < len(list1)
            list2LastNode.next = nodeAfterB;
            return list1;
        }

        // CASE 2 : When a is the last node -> a == idx - 1
        if (a == idx - 1) {
            // CASE 2.1 : When b is the last node -> b == idx - 1
            assert nodeBeforeA != null;
            nodeBeforeA.next = list2;
            return list1;
        }

        // CASE 3 : When a < len(list1) and a > 0
        // CASE 3.1 : When b is the last node -> b == idx - 1
        assert nodeBeforeA != null;
        nodeBeforeA.next = list2;
        if (b == idx - 1) {
            return list1;
        }
        // CASE 3.2 : b < len(list1)
        list2LastNode.next = nodeAfterB;

        return list1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            ListNode head1 = new ListNode(-1);
            ListNode tail1 = head1;
            for (int i = 0; i < n; ++i) {
                tail1.next = new ListNode(sc.nextInt());
                tail1 = tail1.next;
            }
            int a = sc.nextInt();
            int b = sc.nextInt();
            int m = sc.nextInt();
            ListNode head2 = new ListNode(-1);
            ListNode tail2 = head2;
            for (int i = 0; i < m; ++i) {
                tail2.next = new ListNode(sc.nextInt());
                tail2 = tail2.next;
            }

            Solution solution = new Solution();
            ListNode answer = solution.mergeInBetween(head1.next, a, b, head2.next);
            while (answer != null) {
                System.out.print(answer.val + " ");
                answer = answer.next;
            }
        }

        sc.close();
    }
}
