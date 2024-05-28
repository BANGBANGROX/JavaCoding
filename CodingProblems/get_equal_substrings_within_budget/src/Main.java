import java.util.Scanner;
import java.util.TreeMap;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int prefixSum = 0;
        int answer = 0;
        TreeMap<Integer, Integer> sumIndex = new TreeMap<>();

        for (int i = 0; i < n; ++i) {
            prefixSum += Math.abs(s.charAt(i) - t.charAt(i));
            if (prefixSum <= maxCost) {
                answer = i + 1;
            }
            if (sumIndex.ceilingKey(prefixSum - maxCost) != null) {
                answer = Math.max(answer, i - sumIndex.get(sumIndex.ceilingKey(prefixSum - maxCost)));
            }
            if (!sumIndex.containsKey(prefixSum)) {
                sumIndex.put(prefixSum, i);
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
            String s = sc.next();
            String t = sc.next();
            int maxCost = sc.nextInt();

            System.out.println(new Solution().equalSubstring(s, t, maxCost));
        }

        sc.close();
    }
}
