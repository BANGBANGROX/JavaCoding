import java.util.Scanner;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int len1 = s1Arr.length;
        int len2 = s2Arr.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int i = 0;
        int j = 0;

        while (cnt1 < n1) {
            if (s1Arr[i] == s2Arr[j]) {
                ++j;
                if (j == len2) {
                    j = 0;
                    ++cnt2;
                }
            }
            ++i;
            if (i == len1) {
                i = 0;
                ++cnt1;
            }
        }

        return cnt2 / n2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().getMaxRepetitions(scanner.next(),
                    scanner.nextInt(), scanner.next(), scanner.nextInt()));
        }

        scanner.close();
    }
}