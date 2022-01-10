import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    private final List<List<String>> ans = new ArrayList<>();
    private final List<String> currAns = new ArrayList<>();
    private int n;

    private boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0;
        int j = len - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }

        return true;
    }

    private void partitionUtil(String s, int index) {
        if (index >= n) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        for (int len = 1; len <= n - index; ++len) {
            String curr = s.substring(index, index + len);
            if (isPalindrome(curr)) {
                currAns.add(curr);
                partitionUtil(s, index + len);
                currAns.remove(currAns.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
         n = s.length();

         partitionUtil(s, 0);

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
            System.out.println(solution.partition(s));
        }

        sc.close();
    }
}
