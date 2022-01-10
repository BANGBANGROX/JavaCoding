import java.util.Scanner;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {

    private ListNode head;
    private int length;

    public Solution(ListNode head) {
            this.head = head;
            length = 0;

            while (head != null) {
                ++length;
                head = head.next;
            }
    }

    public int getRandom() {
         int index = (int)(Math.random() * (length));
         int count = 0;

         ListNode temp = head;

         while (count != index) {
             temp = temp.next;
             ++count;
         }

         return temp.val;
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
