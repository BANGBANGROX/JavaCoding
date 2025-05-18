import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int[][] dp;
    private List<Set<Integer>> peopleHatsSet;
    private final int TOTAL_HATS = 40;
    private int fullMask;
    private int n;

    public int numberWays(final List<List<Integer>> hats) {
        n = hats.size();
        fullMask = (1 << n) - 1;
        dp = new int[TOTAL_HATS][fullMask + 1];
        peopleHatsSet = new ArrayList<>();

        for (final int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (final List<Integer> hatsList : hats) {
            peopleHatsSet.add(new HashSet<>(hatsList));
        }

        return numberWaysHandler(0, 0);
    }

    private int numberWaysHandler(final int currentHat, final int mask) {
        if (currentHat > TOTAL_HATS) {
            return mask == fullMask ? 1 : 0;
        }

        if (dp[currentHat][mask] != -1) {
            return dp[currentHat][mask];
        }

        final int MOD = (int) 1e9 + 7;
        int result = numberWaysHandler(currentHat + 1, mask);

        for (int i = 0; i < n; ++i) {
            if ((mask & (1 << i)) > 0 || !peopleHatsSet.get(i).contains(currentHat)) {
                continue;
            }
            result = (int) (((long) result + numberWaysHandler(currentHat + 1,
                    mask | (1 << i))) % MOD);
        }

        return dp[currentHat][mask] = result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final List<List<Integer>> hats = new ArrayList<>();
           for (int i = 0; i < n; ++i) {
               hats.add(new ArrayList<>());
               final int totalHats = scanner.nextInt();
               for (int j = 0; j < totalHats; ++j) {
                   hats.get(i).add(scanner.nextInt());
               }
           }

           System.out.println(new Solution().numberWays(hats));
       }
       
       scanner.close();
   }
}
