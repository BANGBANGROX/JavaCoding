import java.util.Scanner;

class Solution {
    public int numOfUnplacedFruits(final int[] fruits, final int[] baskets) {
        final int n = baskets.length;
        boolean[] isTaken = new boolean[n];
        int answer = 0;

        for (final int fruit : fruits) {
            boolean placed = false;

            for (int i = 0; i < n; ++i) {
                if (!isTaken[i] && baskets[i] >= fruit) {
                    isTaken[i] = true;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                ++answer;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] fruits = new int[n];
           for (int i = 0; i < n; ++i) {
               fruits[i] = scanner.nextInt();
           }
           final int[] baskets = new int[n];
           for (int i = 0; i < n; ++i) {
               baskets[i] = scanner.nextInt();
           }

           System.out.println(new Solution().numOfUnplacedFruits(fruits, baskets));
       }
       
       scanner.close();
   }
}
