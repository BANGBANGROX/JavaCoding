import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
       HashSet dictionary = new HashSet(Arrays.asList(bank));
       HashSet<String> visited = new HashSet<>();
       Queue<String> q = new LinkedList<>();
       char[] mutations = {'A', 'C', 'G', 'T'};
       int ans = 0;

       if (!dictionary.contains(end)) return -1;

       if (start.matches(end)) return 0;

       q.add(start);
       visited.add(start);

       while (!q.isEmpty()) {
           int size = q.size();
           for (int i = 0; i < size; ++i) {
               assert q.peek() != null;
               String currentWord = q.poll();
               for (int j = 0; j < currentWord.length(); ++j) {
                   String before = j == 0 ? "" : currentWord.substring(0, j - 1);
                   String after = j == currentWord.length() - 1 ? "" : currentWord.substring(j + 1);
                   for (int k = 0; k < 4; ++k) {
                       String mutation = before + mutations[k] + after;
                       if (dictionary.contains(mutation) && !visited.contains(mutation)) {
                           if (mutation.matches(end)) return ans + 1;
                           visited.add(mutation);
                           q.add(mutation);
                       }
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
            String start = sc.next();
            String end = sc.next();
            int n = sc.nextInt();
            String[] bank = new String[n];
            for (int i = 0; i < n; ++i) {
                bank[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.minMutation(start, end, bank));
        }

        sc.close();
    }
}
