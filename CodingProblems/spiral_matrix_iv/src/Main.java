import java.util.Arrays;
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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        int firstRow = 0;
        int lastRow = m - 1;
        int firstCol = 0;
        int lastCol = n - 1;
        ListNode current = head;

        for (int[] row : answer) {
            Arrays.fill(row, -1);
        }

        while (firstRow <= lastRow && firstCol <= lastCol && current != null) {
            for (int i = firstCol; i <= lastCol && current != null; ++i,
                    current = current.next) {
                answer[firstRow][i] = current.val;
            }
            ++firstRow;
            for (int i = firstRow; i <= lastRow && current != null; ++i,
                    current = current.next) {
                answer[i][lastCol] = current.val;
            }
            --lastCol;
            for (int i = lastCol; i >= firstCol && current != null; --i,
                    current = current.next) {
                answer[lastRow][i] = current.val;
            }
            --lastRow;
            for (int i = lastRow; i >= firstRow && current != null; --i,
                    current = current.next) {
                answer[i][firstCol] = current.val;
            }
            ++firstCol;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int n = scanner.nextInt();
           ListNode head = new ListNode(-1);
           ListNode tail = head;
           int nodes = scanner.nextInt();
           for (int i = 0; i < nodes; ++i) {
               tail.next = new ListNode(scanner.nextInt());
               tail = tail.next;
           }

           int[][] answer = new Solution().spiralMatrix(m, n, head.next);
           for (int[] row : answer) {
               for (int x : row) {
                   System.out.print(x + " ");
               }
               System.out.println();
           }
       }
       
       scanner.close();
   }
}
