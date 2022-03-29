import java.util.Scanner;

class Solution {
    public String minRemoveToMakeValid(String s) {
         int n = s.length();
         int difference = 0;
         StringBuilder initialResult = new StringBuilder();

         for (int i = 0; i < n; ++i) {
             if (s.charAt(i) == '(') {
                 ++difference;
                 initialResult.append(s.charAt(i));
             }
             else if (s.charAt(i) == ')') {
                 if (difference > 0) {
                     --difference;
                     initialResult.append(s.charAt(i));
                 }
             }
             else initialResult.append(s.charAt(i));
         }

         if (difference == 0) return initialResult.toString();

         StringBuilder ans = new StringBuilder();

         for (int i = initialResult.length() - 1; i >= 0; --i) {
             if (initialResult.charAt(i) == '(') {
                 if (difference > 0) {
                     --difference;
                 }
                 else ans.append(initialResult.charAt(i));
             }
             else if (s.charAt(i) == ')') {
                 if (difference == 0) ans.append(')');
             }
             else ans.append(initialResult.charAt(i));
         }

        ans.reverse();

        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minRemoveToMakeValid(s));
        }

        sc.close();
    }
}
