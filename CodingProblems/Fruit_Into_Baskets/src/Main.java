import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int l = 0;
        int n = fruits.length;
        int ans = 0;

        for (int r = 0; r < n; ++r) {
            count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[l], count.get(fruits[l]) - 1);
                if (count.get(fruits[l]) == 0) count.remove(fruits[l]);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] fruits = new int[n];
            for (int i = 0; i < n; ++i) {
                fruits[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.totalFruit(fruits));
        }

        sc.close();
    }
}
