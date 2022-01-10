import java.util.Scanner;

class Solution {
    public String addBinary(String a, String b) {
       int m = a.length();
       int n = b.length();
       int carry = 0;
       int i = m - 1;
       int j = n - 1;
       StringBuilder ans = new StringBuilder();

       while (i >= 0 && j >= 0) {
           char ch1 = a.charAt(i);
           char ch2 = b.charAt(j);
           if (ch1 == '0' && ch2 == '0') {
               ans.insert(0, carry);
               carry = 0;
           }
           else if (ch1 == '0') {
               if (carry == 0) ans.insert(0, 1);
               else {
                   ans.insert(0, 0);
               }
           }
           else if (ch2 == '0') {
               if (carry == 0) ans.insert(0, 1);
               else {
                   ans.insert(0, 0);
               }
           }
           else {
               if (carry == 0) {
                   ans.insert(0, 0);
               }
               else {
                   ans.insert(0, 1);
               }
               carry = 1;
           }
           --i;
           --j;
       }

       while (i >= 0) {
           char ch = a.charAt(i);
           if (carry == 0) ans.insert(0, (ch - '0'));
           else {
               if (ch == '1') ans.insert(0, 0);
               else {
                   ans.insert(0, 1);
                   carry = 0;
               }
           }
           --i;
       }

       while (j >= 0) {
           char ch = b.charAt(j);
           if (carry == 0) ans.insert(0, (ch - '0'));
           else {
               if (ch == '1') ans.insert(0, 0);
               else {
                   ans.insert(0, 1);
                   carry = 0;
               }
           }
           --j;
       }

       if (carry != 0) ans.insert(0, carry);

       return ans.toString();
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
            System.out.println(solution.addBinary(a, b));
        }

        sc.close();
    }
}
