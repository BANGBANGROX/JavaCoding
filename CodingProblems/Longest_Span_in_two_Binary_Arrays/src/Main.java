//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean[] arr1 = new boolean[n];
            boolean[] arr2 = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1");
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1");
            }

            int ans = new Solution().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSum(boolean[] arr1, boolean[] arr2, int n) {
        // code here
        int[] zeroPrefix1 = new int[n];
        int[] zeroPrefix2 = new int[n];
        HashMap<Integer, Integer> previous = new HashMap<>();
        int ans = 0;

        zeroPrefix1[0] = !arr1[0] ? 1 : 0;
        zeroPrefix2[0] = !arr2[0] ? 1 : 0;

        for (int i = 1; i < n; ++i) {
            zeroPrefix1[i] = zeroPrefix1[i - 1] + (!arr1[i] ? 1 : 0);
            zeroPrefix2[i] = zeroPrefix2[i - 1] + (!arr2[i] ? 1 : 0);
        }

        for (int i = 0; i < n; ++i) {
            int currentDiff = zeroPrefix1[i] - zeroPrefix2[i];
            if (currentDiff == 0) ans = Math.max(ans, i + 1);
            if (!previous.containsKey(currentDiff)) {
                previous.put(currentDiff, i);
                continue;
            }
            int last = previous.get(currentDiff);
            ans = Math.max(ans, i - last);
        }

        return ans;
    }
}