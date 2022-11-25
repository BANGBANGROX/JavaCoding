//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            Solution obj = new Solution();
            String[] arr = sc.nextLine().split(" ");
            System.out.println(obj.mostFrequentWord(arr));

        }
    }
}

// } Driver Code Ends
//User function Template for Java


class Solution {
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String[] arr) {
        // code here
        HashMap<String, Integer> count = new HashMap<>();
        int maxCount = 0;
        String ans = "";

        for (String s : arr) {
            count.put(s, count.getOrDefault(s, 0) + 1);
            maxCount = Math.max(maxCount, count.get(s));
        }

        for (String s : arr) {
            if (count.get(s) == maxCount) {
                ans = s;
                count.put(s, 0);
            }
        }

        return ans;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends