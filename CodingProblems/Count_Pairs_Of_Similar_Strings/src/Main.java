import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private int calculateValue(String s) {
        int ans = 0;

        for (char ch : s.toCharArray()) {
            ans |= (1 << (ch - 'a'));
        }

        return ans;
    }

    public int similarPairs(String[] words) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            int value = calculateValue(word);
            count.put(value, count.getOrDefault(value, 0) + 1);
        }

        for (int val : count.keySet()) {
            int x = count.get(val);
            ans += x * (x - 1) / 2;
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
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.similarPairs(words));
        }

        sc.close();
    }
}
