//{ Driver Code Starts
//Initial Template for Java
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] input;
            input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.sumOfAll(l, r));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int sumOfAll(int l, int r) {
        // code here
        int[] sumOfPrimeFactors = new int[r + 1];

        for (int i = 2; i <= r; ++i) {
            if (sumOfPrimeFactors[i] == 0) {
                for (int j = 2 * i; j <= r; j += i) {
                    sumOfPrimeFactors[j] += i;
                }
            }
        }

        for (int i = 1; i <= r; ++i) {
            if (sumOfPrimeFactors[i] == 0) sumOfPrimeFactors[i] = i;
            sumOfPrimeFactors[i] += sumOfPrimeFactors[i - 1];
        }

        return sumOfPrimeFactors[r] - sumOfPrimeFactors[l - 1];
    }
}