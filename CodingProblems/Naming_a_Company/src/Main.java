import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;
        HashSet<String>[] suffixes = new HashSet[26];

        for (int i = 0; i < 26; ++i) {
            suffixes[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            suffixes[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                long mutual = 0;
                for (String s : suffixes[i]) {
                    if (suffixes[j].contains(s)) ++mutual;
                }
                ans += 2 * (suffixes[i].size() - mutual) * (suffixes[j].size() - mutual);
            }
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
            String[] ideas = new String[n];
            for (int i = 0; i < n; ++i) {
                ideas[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.distinctNames(ideas));
        }

        sc.close();
    }
}
