import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Solution {
    private int maxLengthUtil(List<String> arr, String s, int ind) {
        HashSet<Character> st = new HashSet<>();

        for (char ch : s.toCharArray()) {
            st.add(ch);
        }

        if (st.size() != s.length()) return 0;

        int ans = s.length();

        for (int i = ind; i < arr.size(); ++i) {
            ans = Math.max(ans, maxLengthUtil(arr, s + arr.get(i), i + 1));
        }

        return ans;
    }

    public int maxLength(List<String> arr) {
       return maxLengthUtil(arr, "", 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String s = sc.next();
                arr.add(s);
            }

            Solution solution = new Solution();
            System.out.println(solution.maxLength(arr));
        }

        sc.close();
    }
}
