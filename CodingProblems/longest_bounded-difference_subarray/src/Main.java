//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


// } Driver Code Ends


class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        int start = 0;
        int end = 0;
        int left = 0;
        Map<Integer, Integer> count = new HashMap<>();
        TreeSet<Integer> nums = new TreeSet<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int right = 0; right < n; ++right) {
            nums.add(arr[right]);
            count.put(arr[right], count.getOrDefault(arr[right], 0) + 1);
            if (nums.last() - nums.first() > x) {
                while (left < right && (nums.last() - nums.first()) > x) {
                    count.put(arr[left], count.get(arr[left]) - 1);
                    if (count.get(arr[left]) == 0) {
                        nums.remove(arr[left]);
                    }
                    ++left;
                }
            }
            if (right - left + 1 > end - start + 1) {
                start = left;
                end = right;
            }
        }

        for (int i = start; i <= end; ++i) {
            answer.add(arr[i]);
        }

        return answer;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends