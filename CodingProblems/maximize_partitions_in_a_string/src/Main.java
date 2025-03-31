//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        Map<Character, Integer> lastIndex = new HashMap<>();
        int answer = 0;
        int lastEnd = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            lastIndex.put(s.charAt(i), i);
        }

        for (int i = 0; i < n; ++i) {
            lastEnd = Math.max(lastEnd, lastIndex.get(s.charAt(i)));
            if (i == lastEnd) {
                ++answer;
            }
        }

        return answer;
    }
}