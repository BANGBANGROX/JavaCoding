import java.util.Scanner;

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder num = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int val = ch - 'a' + 1;
            num.append(val);
        }

        while (k-- > 0) {
            int sum = 0;
            for (char ch : num.toString().toCharArray()) {
                sum += (ch - '0');
            }
            num = new StringBuilder(String.valueOf(sum));
        }

        return Integer.parseInt(num.toString());
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().getLucky(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
