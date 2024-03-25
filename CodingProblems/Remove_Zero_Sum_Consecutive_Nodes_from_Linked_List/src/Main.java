import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // 1 2 3 -3 4
        // 1 3 6 3 7
        int prefixSum = 0;
        int itr = 0;
        HashMap<Integer, Integer> prefixSumIndices = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode currentNode = head;

        while (currentNode != null) {
            prefixSum += currentNode.val;
            if (prefixSum == 0) {
                currentNode = currentNode.next;
                ListNode nextHead = new ListNode(-1);
                ListNode nextTail = nextHead;
                while (currentNode != null) {
                    nextTail.next = new ListNode(currentNode.val);
                    nextTail = nextTail.next;
                    currentNode = currentNode.next;
                }
                return removeZeroSumSublists(nextHead.next);
            }
            if (prefixSumIndices.containsKey(prefixSum)) {
                int idx1 = prefixSumIndices.get(prefixSum);
                ListNode nextHead = new ListNode(-1);
                ListNode nextTail = nextHead;
                for (int i = 0; i <= idx1; ++i) {
                    nextTail.next = new ListNode(nums.get(i));
                    nextTail = nextTail.next;
                }
                currentNode = currentNode.next;
                while (currentNode != null) {
                    nextTail.next = new ListNode(currentNode.val);
                    nextTail = nextTail.next;
                    currentNode = currentNode.next;
                }
                return removeZeroSumSublists(nextHead.next);
            }
            prefixSumIndices.put(prefixSum, itr);
            nums.add(currentNode.val);
            ++itr;
            currentNode = currentNode.next;
        }

        return prefixSum == 0 ? null : head;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            for (int i = 0; i < n; ++i) {
                tail.next = new ListNode(sc.nextInt());
                tail = tail.next;
            }

            Solution solution = new Solution();
            System.out.println(solution.removeZeroSumSublists(head.next));
        }

        sc.close();
    }
}
