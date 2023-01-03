//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().sumBitDifferences(arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    public long sumBitDifferences(int[] nums) {
        // code here
        long ans = 0;

        for (int i = 0; i < 32; ++i) {
            int setBitsCount = 0;
            int unsetBitsCount = 0;
            for (int num : nums) {
                if ((num & (1 << i)) > 0) ++setBitsCount;
                else ++unsetBitsCount;
            }
            ans += 2L * setBitsCount * unsetBitsCount;
        }

        return ans;
    }
}