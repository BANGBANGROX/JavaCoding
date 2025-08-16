import java.util.Scanner;

class Solution {
    public int maximum69Number(final int num) {
        final char[] numCharArr = String.valueOf(num).toCharArray();
        final int n = numCharArr.length;

        for (int i = 0; i < n; ++i) {
            if (numCharArr[i] == '6') {
                numCharArr[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(numCharArr));
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().maximum69Number(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
