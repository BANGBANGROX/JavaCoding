import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int[] lastOccurrence = new int[26];

        for (int i = 0; i < n; ++i) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; ++i) {
            int len = 0;
            int last = lastOccurrence[s.charAt(i) - 'a'];
            while (i <= last) {
                last = Math.max(last, lastOccurrence[s.charAt(i) - 'a']);
                ++i;
                ++len;
            }
            --i;
            ans.add(len);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.partitionLabels(s));
        }

        sc.close();
    }
}
