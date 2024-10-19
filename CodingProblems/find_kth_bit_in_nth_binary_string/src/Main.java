import java.util.Scanner;

class Solution {
    public char findKthBit(int n, int k) {
       if (n == 1 || k == 1) return '0';

       int length = (1 << n) - 1;
       int mid = length / 2;

       // Middle character is always 1
       if (mid == k - 1) return '1';

       // This means we have the answer as the kth character of the last string
       if (k - 1 < mid) return findKthBit(n - 1, k);

       // This means we have the answer as the inversion of kth character of the last string
       // Which means inversion of (length - k + 1)th character of last string
       return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().findKthBit(scanner.nextInt(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
