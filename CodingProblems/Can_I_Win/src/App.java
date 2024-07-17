import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<Integer, Boolean> dp;
    private boolean[] visited;

    private int computeHash() {
        int hash = 0;

        for (int i = 1; i < visited.length; ++i) {
            if (visited[i]) {
                hash |= (1 << i);
            }
        }

        return hash;
    }

    private boolean canIWinHandler(int totalLeft) {
        if (totalLeft <= 0) return false;

        int key = computeHash();
        boolean result = false;

        if (dp.containsKey(key)) return dp.get(key);

        for (int i = 1; i < visited.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                if (!canIWinHandler(totalLeft - i)) {
                    visited[i] = false;
                    result = true;
                    break;
                }
                visited[i] = false;
            }
        }

        dp.put(key, result);

        return result;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int maxPossibleSum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        
        if (maxPossibleSum < desiredTotal) return false;

        if (desiredTotal == 0) return true;

        dp = new HashMap<>();
        visited = new boolean[maxChoosableInteger + 1];

        return canIWinHandler(desiredTotal);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int maxChoosableInteger = scanner.nextInt();
            int desiredTotal = scanner.nextInt();

            System.out.println(new Solution().canIWin(maxChoosableInteger, desiredTotal));
        }

        scanner.close();
    }
}
