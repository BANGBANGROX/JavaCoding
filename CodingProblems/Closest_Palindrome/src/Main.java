// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            long num = Long.parseLong(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.closestPalindrome(num);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private long generatePalindrome(long num, boolean isOdd) {
        StringBuilder stringNum = new StringBuilder(String.valueOf(num));
        int n = stringNum.length();
        int l = n - 1;

        if (isOdd) --l;

        while (l >= 0) {
            stringNum.append(stringNum.charAt(l));
            --l;
        }

        return Long.parseLong(stringNum.toString());
    }

    private long findClosest(long num, long num1, long num2, long num3) {
        long diff1 = Math.abs(num - num1);
        long diff2 = Math.abs(num - num2);
        long diff3 = Math.abs(num - num3);

        if (diff1 < diff2) {
            if (diff1 < diff3) return num1;
            else if (diff1 == diff3) return Math.min(num1, num3);
            return num3;
        }

        if (diff1 == diff2) {
            if (diff1 < diff3) return Math.min(num1, num2);
            return num3;
        }

        if (diff2 < diff3) return num2;
        else if (diff2 == diff3) return Math.min(num2, num3);
        return num3;
    }

    public long closestPalindrome(long num) {
        // Code here
        if (num < 10) return num;

        if (Math.log10(num) == Math.floor(Math.log10(num))) return num - 1;

        String stringNum = String.valueOf(num);
        int n = stringNum.length();
        StringBuilder palindromeNum = new StringBuilder();
        boolean isOdd = n % 2 == 1;

        for (int i = 0; i < n / 2; ++i) {
            palindromeNum.append(stringNum.charAt(i));
        }

        if (isOdd) palindromeNum.append(stringNum.charAt(n / 2));

        long ans1 = generatePalindrome(Long.parseLong(palindromeNum.toString()), isOdd);
        long ans2 = generatePalindrome(Long.parseLong(palindromeNum.toString()) - 1, isOdd);
        long ans3 = generatePalindrome(Long.parseLong(palindromeNum.toString()) + 1, isOdd);

        return findClosest(num, ans1, ans2, ans3);
    }
}