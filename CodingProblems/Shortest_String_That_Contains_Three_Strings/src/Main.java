import java.util.Scanner;

class Solution {
    private String getLexicographicallySmallerString(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (m < n) return a;

        if (m == n) return (a.compareTo(b) < 0 ? a : b);

        return b;
    }

    private String combineTwoStringsWithOverlap(String a, String b) {
        if (b.contains(a)) return b;

        int m = a.length();
        int n = b.length();

        for (int i = 0; i < m; ++i) {
            String s1 = a.substring(i);
            String s2 = b.substring(0, Math.min(n, m - i));
            if (s1.equals(s2)) return a + b.substring(Math.min(n, m - i));
        }

        return a + b;
    }

    private String minimumStringHandler(String a, String b, String c) {
        String s1 = combineTwoStringsWithOverlap(a, b);
        String s2 = combineTwoStringsWithOverlap(b, a);
        String s3 = getLexicographicallySmallerString(combineTwoStringsWithOverlap(s1, c),
                combineTwoStringsWithOverlap(c, s1));
        String s4 = getLexicographicallySmallerString(combineTwoStringsWithOverlap(s2, c),
                combineTwoStringsWithOverlap(c, s2));

        return getLexicographicallySmallerString(s3, s4);
    }

    public String minimumString(String a, String b, String c) {
         String s1 = minimumStringHandler(a, b, c);
         String s2 = minimumStringHandler(b, c, a);
         String s3 = minimumStringHandler(c, a, b);

         return getLexicographicallySmallerString(getLexicographicallySmallerString(s1, s2), s3);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minimumString(a, b, c));
        }

        sc.close();
    }
}
