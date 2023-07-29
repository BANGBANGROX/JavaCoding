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
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String s[] = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            ot.println(new Solution().minIndex(n, arr));
        }
        ot.close();
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    public int minIndex(int n, int[] nums){
        // Code Here.
        int maximumValue = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[5 * maximumValue + 1];
        int answer = 0;
        int maxCount = -1;

        for (int i = 0; i < n; ++i) {
            ++count[nums[i]];
        }

        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            int cnt = count[5 * nums[i]] - count[2 * nums[i] - 1];
            if (cnt > maxCount) {
                answer = i;
                maxCount = cnt;
            }
        }

        return answer;
    }
}
