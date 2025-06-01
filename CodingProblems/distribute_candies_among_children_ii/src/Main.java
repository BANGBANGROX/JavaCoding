import java.util.Scanner;

class Solution {
    public long distributeCandies(int n, int limit) {
        return calc(n + 2) -
                3 * calc(n - limit + 1) +
                3 * calc(n - 2 * (limit + 1) + 2) -
                calc(n - 3 * (limit +  1) + 2);
    }

    private long calc(int x) {
        if (x < 0) {
            return 0;
        }

        return (long) x * (x - 1) / 2;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().distributeCandies(scanner.nextInt(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
