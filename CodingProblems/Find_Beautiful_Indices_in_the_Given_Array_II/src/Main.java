import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private String s;
    private int[] lps;

    private int[] computeLPSArray() {
        lps = new int[s.length()];
        int len = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                ++len;
                lps[i] = len;
                ++i;
            }
            else {
                if (len == 0) ++i;
                else len = lps[len - 1];
            }
        }

        return lps;
    }

    private List<Integer> getMatchingIndices(String a) {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < s.length()) {
            if (s.charAt(i) == a.charAt(j)) {
                ++i;
                ++j;
            }
            if (j == a.length()) {
                result.add(i - j);
                j = lps[j - 1];
            }
            else if (i < s.length() && s.charAt(i) != a.charAt(j)) {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }

        return result;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        this.s = s;
        lps = computeLPSArray();
        List<Integer> aIndices = getMatchingIndices(a);
        List<Integer> bIndices = getMatchingIndices(b);
        List<Integer> answer = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < aIndices.size() && ptr2 < bIndices.size()) {
            int i = aIndices.get(ptr1);
            int j = bIndices.get(ptr2);
            if (Math.abs(i - j) <= k) {
                answer.add(i);
                ++ptr1;
            }
            else if (i > j) {
                ++ptr2;
            }
            else {
                ++ptr1;
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
            String a = sc.next();
            String b = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.beautifulIndices(s, a, b, k));
        }

        sc.close();
    }
}
