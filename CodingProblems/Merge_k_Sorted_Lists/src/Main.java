import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    private ListNode mergeLists(ListNode list1, ListNode list2) {
         ListNode head = new ListNode(0);
         ListNode tail = head;

         while (list1 != null && list2 != null) {
             if (list1.val < list2.val) {
                 tail.next = list1;
                 list1 = list1.next;
                 tail = tail.next;
             }
             else {
                 tail.next = list2;
                 list2 = list2.next;
                 tail = tail.next;
             }
         }

         tail.next = (list1 != null) ? list1 : list2;

         return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
           int n = lists.length;
           int last = n - 1;

           while (last > 0) {
               int i = 0;
               int j = last;
               while (i < j) {
                   lists[i] = mergeLists(lists[i], lists[j]);
                   ++i;
                   --j;
                   if (i >= j) {
                       last = j;
                       break;
                   }
               }
           }

           return lists[0];
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
