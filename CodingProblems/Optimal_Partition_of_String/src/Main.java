import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public int partitionString(String s) {
        int ans = 0;
        HashSet<Character> visited = new HashSet<>();

        for (char ch : s.toCharArray()) {
           if (visited.contains(ch)) {
               visited.clear();
               ++ans;
           }
           visited.add(ch);
        }

        ++ans;

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
            System.out.println(solution.partitionString(s));
        }

        sc.close();
    }
}
