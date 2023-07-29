//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    private boolean isPalindrome(char[] charArray) {
        int l = 0;
        int r = charArray.length - 1;

        while (l < r) {
            if (charArray[l] == charArray[r]) {
                ++l;
                --r;
            }
            else if (charArray[l] == '?') {
                charArray[l] = charArray[r];
                ++l;
                --r;
            }
            else if (charArray[r] == '?') {
                charArray[r] = charArray[l];
                ++l;
                --r;
            }
            else return true;
        }

        return false;
    }

    public int minimumSum(String s) {
        // code here
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int answer = 0;

        if (isPalindrome(charArray)) return -1;

        for (int i = 1; i < (n + 1) / 2; ++i) {
            if (charArray[i - 1] == '?') continue;
            if (charArray[i] == '?') charArray[i] = charArray[i - 1];
            else answer += 2 * Math.abs(charArray[i] - charArray[i - 1]);
        }

        return answer;
    }
}