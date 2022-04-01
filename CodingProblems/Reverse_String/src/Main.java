import java.util.Scanner;

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            ++i;
            --j;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            char[] s = new char[n];
            for (int i = 0; i < n; ++i) {
                s[i] = sc.next().charAt(0);
            }

            Solution solution = new Solution();
            solution.reverseString(s);
            for (int i = 0; i < n; ++i) {
                System.out.print(s[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
