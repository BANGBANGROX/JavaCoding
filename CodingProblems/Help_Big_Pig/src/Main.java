// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[] = new int[n], b[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(s[i]);
            }

            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                b[i] = Integer.parseInt(s[i]);
            }
            int q[] = new int[m];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < m; i++){
                q[i] = Integer.parseInt(s[i]);
            }
            int ans[] = new Solution().findMin(n, m, a, b, q);
            for(int x : ans)
                ot.print(x + " ");
            ot.println();
        }
        ot.close();
    }
} // } Driver Code Ends


//User function Template for Java

class Solution {
    private void decreasingOrderSort(long[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            long temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }
    }

    private int lowerBound(long[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int answer = -2;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] >= key) {
                answer = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return answer;
    }

    public int[] findMin(int n, int q, int[] gain, int[] loss, int[] query) {
        // Code Here.
        long[] overallGain = new long[n];
        int[][] indexedQuery = new int[n][2];
        int[] answer = new int[q];

        for (int i = 0; i < n; ++i) {
            overallGain[i] = gain[i] - loss[i];
        }

        for (int i = 0; i < q; ++i) {
            indexedQuery[i][0] = query[i];
            indexedQuery[i][1] = i;
        }

        Arrays.sort(in)
        decreasingOrderSort(overallGain);

        for (int i = 1; i < n; ++i) {
            overallGain[i] += overallGain[i - 1];
        }

        for (int i = 0; i < q; ++i) {
            if (query[i] == 0) {
                answer[i] = 0;
                continue;
            }
            answer[i] = lowerBound(overallGain, query[i]) + 1;
        }

        return answer;
    }
}