import java.util.Scanner;

class Solution {
    public int repeatedStringMatch(String a, String b) {
        String initialString = a;
        int ans = 1;
        StringBuilder aBuilder = new StringBuilder(a);

        while (aBuilder.length() < b.length()) {
            aBuilder.append(initialString);
            ++ans;
        }

        a = aBuilder.toString();

        if (a.contains(b)) return ans;

        a += initialString;
        ++ans;

        if (a.contains(b)) return ans;

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String a = sc.next();
            String b = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.repeatedStringMatch(a, b));
        }

        sc.close();
    }
}
