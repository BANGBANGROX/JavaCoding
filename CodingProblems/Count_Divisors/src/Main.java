//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.DivCountSum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] spf;

    private void buildSpf(int n) {
        spf = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            spf[i] = i;
        }

        for (int i = 2; i <= n; ++i) {
            if (spf[i] == i) {
                for (int j = 2 * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    private int findDivCount(int num) {
        int primeNum = spf[num];
        int ans = 1;

        while (primeNum != 1) {
            int cnt = 0;
            while (num % primeNum == 0) {
                num /= primeNum;
                ++cnt;
            }
            ans *= (cnt + 1);
            primeNum = spf[num];
        }

        return ans;
    }

    public int DivCountSum(int n) {
        // Code here
        buildSpf(n);

        int ans = 0;

        for (int i = 1; i <= n; ++i) {
            ans += findDivCount(i);
        }

        return ans;
    }
}