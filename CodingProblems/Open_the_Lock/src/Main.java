import java.util.*;

class Solution {
    public int openLock(String[] deadEnds, String target) {
        HashSet<String> dictionary = new HashSet(Arrays.asList(deadEnds));
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int ans = 0;

        if (dictionary.contains("0000")) return -1;

        if (target.matches("0000")) return 0;

        q.add("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                assert q.peek() != null;
                String current = q.poll();
                for (int j = 0; j < 4; ++j) {
                   String before = j == 0 ? "" : current.substring(0, j);
                   String after = j == 3 ? "" : current.substring(j + 1);
                   int currentDigit = current.charAt(j) - '0';
                   char nextDigit1 = (currentDigit == 0 ? '9' : (char)(currentDigit - 1 + '0'));
                   char nextDigit2 = (currentDigit == 9 ? '0' : (char)(currentDigit + 1 + '0'));
                   String mutation1 = before + nextDigit1 + after;
                   String mutation2 = before + nextDigit2 + after;
                   if (!dictionary.contains(mutation1) && !visited.contains(mutation1)) {
                       if (mutation1.matches(target)) return ans + 1;
                       q.add(mutation1);
                       visited.add(mutation1);
                   }
                    if (!dictionary.contains(mutation2) && !visited.contains(mutation2)) {
                        if (mutation2.matches(target)) return ans + 1;
                        q.add(mutation2);
                        visited.add(mutation2);
                    }
                }
            }
            ++ans;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] deadEnds = new String[n];
            for (int i = 0; i < n; ++i) {
                deadEnds[i] = sc.next();
            }
            String target = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.openLock(deadEnds, target));
        }

        sc.close();
    }
}
