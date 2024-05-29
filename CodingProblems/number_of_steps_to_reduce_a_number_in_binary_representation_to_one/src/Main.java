import java.util.Scanner;

class Solution {
    private String divideByTwo(String s) {
        // 110 - 6
        // 011 - 3
        // Right Shift by 1
        char[] sArray = s.toCharArray();
        int n = sArray.length;
        char lastChar = sArray[n - 1];

        System.arraycopy(sArray, 0, sArray, 1, n - 1);
        sArray[0] = lastChar;

        return new String(sArray);
    }

    private String addOne(String s) {
        char[] sArray = s.toCharArray();
        int carry = 1;
        int n = sArray.length;

        for (int i = n - 1; i >= 0; --i) {
            if (sArray[i] == '1' && carry == 1) {
                sArray[i] = '0';
            }
            else if (sArray[i] == '1' && carry == 0) {
                sArray[i] = '1';
            }
            else if (sArray[i] == '0' && carry == 1) {
                sArray[i] = '1';
                carry = 0;
            }
            else if (sArray[i] == '0' && carry == 0) {
                sArray[i] = '0';
            }
        }

        if (carry > 0) {
            return "1" + new String(sArray);
        }

        return new String(sArray);
    }

    private boolean isOne(String s) {
        int n = s.length();

        if (s.charAt(n - 1) != '1') return false;

        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) != '0') return false;
        }

        return true;
    }

    public int numSteps(String s) {
        int answer = 0;

        while (!isOne(s)) {
            if (s.charAt(s.length() - 1) == '1') {
                s = addOne(s);
            }
            else {
                s = divideByTwo(s);
            }
            ++answer;
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

            System.out.println(new Solution().numSteps(s));
        }

        sc.close();
    }
}
