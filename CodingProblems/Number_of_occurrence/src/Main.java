//{ Driver Code Starts
//Initial Template for Java


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    private int findFirstOccurrence(int[] nums, int n, int key) {
         int start = 0;
         int end = n - 1;
         int answer = -1;

         while (start <= end) {
             int mid = (start + ((end - start) >> 1));
             if (nums[mid] == key) {
                 answer = mid;
                 end = mid - 1;
             }
             else if (nums[mid] > key) end = mid - 1;
             else start = mid + 1;
         }

         return answer;
    }

    private int findLastOccurrence(int[] nums, int n, int key) {
        int start = 0;
        int end = n - 1;
        int answer = -1;

        while (start <= end) {
            int mid = (start + ((end - start) >> 1));
            if (nums[mid] == key) {
                answer = mid;
                start = mid + 1;
            }
            else if (nums[mid] < key) start = mid + 1;
            else end = mid - 1;
        }

        return answer;
    }

    public int count(int[] nums, int n, int key) {
        // code here
        int firstPosition = findFirstOccurrence(nums, n, key);

        if (firstPosition == -1) return 0;

        int lastPosition = findLastOccurrence(nums, n, key);

        return (lastPosition - firstPosition + 1);
    }
}