//{ Driver Code Starts
// Initial Template for Java

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//{ Driver Code Starts
// Initial Template for Java


// } Driver Code Ends


class Solution {
    public int longestStringChain(String[] words) {
        // code here
        Map<String, Integer> dp = new HashMap<>();
        int answer = 1;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            int maxLen = 0;
            for (int i = 0; i < word.length(); ++i) {
                String previousString = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(previousString)) {
                    maxLen = Math.max(maxLen, dp.get(previousString));
                }
            }
            dp.put(word, maxLen + 1);
            answer = Math.max(answer, dp.get(word));
        }

        return answer;
    }
}