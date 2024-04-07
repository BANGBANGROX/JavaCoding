//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    private String num;

    private boolean check(int firstNumber, int secondNumber, int startingIndex) {
        int n = num.length();

        for (int i = startingIndex; i < n; ++i) {
            int requiredNumber = firstNumber + secondNumber;
            int thirdNumber = 0;
            while (i < n && thirdNumber < requiredNumber) {
                thirdNumber = thirdNumber * 10 + (num.charAt(i) - '0');
                ++i;
            }
            if (thirdNumber != requiredNumber) return false;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            --i;
        }

        return true;
    }

    public boolean isAdditiveSequence(String num) {
        // code here
        this.num = num;
        int n = num.length();
        int firstNumber = 0;

        for (int i = 0; i < n - 2; ++i) {
            firstNumber = firstNumber * 10 + (num.charAt(i) - '0');
            int secondNumber = 0;
            for (int j = i + 1; j < n - 1; ++j) {
                secondNumber = secondNumber * 10 + (num.charAt(j) - '0');
                if (check(firstNumber, secondNumber, j + 1)) return true;
            }
        }

        return false;
    }
}
