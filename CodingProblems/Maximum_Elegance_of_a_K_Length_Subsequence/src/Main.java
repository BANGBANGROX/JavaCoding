import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        long profitSum = 0;
        ArrayList<Integer> duplicateProfit = new ArrayList<>();
        HashSet<Integer> visitedCategories = new HashSet<>();

        Arrays.sort(items, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        for (int i = 0; i < k; ++i) {
            if (visitedCategories.contains(items[i][1])) {
                duplicateProfit.add(items[i][0]);
            }
            else {
                visitedCategories.add(items[i][1]);
            }
            profitSum += items[i][0];
        }

        long answer = profitSum + (long) visitedCategories.size() * visitedCategories.size();

        for (int i = k, j = duplicateProfit.size() - 1; i < n && j >= 0; ++i) {
            if (!visitedCategories.contains(items[i][1])) {
                visitedCategories.add(items[i][1]);
                profitSum = profitSum - duplicateProfit.get(j) + items[i][0];
                answer = Math.max(answer, profitSum +
                        (long) visitedCategories.size() * visitedCategories.size());
                --j;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] items = new int[n][2];
            for (int i = 0; i < n; ++i) {
                items[i][0] = sc.nextInt();
                items[i][1] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.findMaximumElegance(items, k));
        }

        sc.close();
    }
}
