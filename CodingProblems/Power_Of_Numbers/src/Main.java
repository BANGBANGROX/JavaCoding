//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.Scanner;

class Main {

    // compute reverse of a number
    public static long rev(long n) {
        long rev_num = 0;
        while (n > 0) {
            rev_num = rev_num * 10 + n % 10;
            n = n / 10;
        }
        return rev_num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //testcases
        int T = sc.nextInt();
        while (T-- > 0) {
            Solution obj = new Solution();

            int N;


            //input N
            N = sc.nextInt();
            int R;


            // reverse the given number n
            R = (int) rev(N);

            //power of the number to it's reverse
            long ans = obj.power(N, R);
            System.out.println(ans);


        }

    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public long power(long num, long reverseNum) {
        //Your code here
        long answer = 1;
        final int MOD = 1_000_000_007;

        while (reverseNum > 0) {
            if ((reverseNum & 1) > 0) {
                answer = (answer * num) % MOD;
                --reverseNum;
            }
            num = (num * num) % MOD;
            reverseNum >>= 1;
        }

        return answer;
    }

}
