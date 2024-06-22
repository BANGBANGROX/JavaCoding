//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private boolean isValid(String word) {
        for (char ch : word.toCharArray()) {
            if (ch == '9' || ch < '0' || ch > '9') return false;
        }

        return true;
    }

    public long ExtractNumber(String sentence) {
        // code here
        String[] words = sentence.split(" ");
        long answer = -1;

        for (String word : words) {
            if (isValid(word)) {
                answer = Math.max(answer, Long.parseLong(word));
            }
        }

        return answer;
    }
}