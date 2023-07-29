//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String str;
            str = br.readLine();

            Solution obj = new Solution();
            String res = obj.stringMirror(str);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public String stringMirror(String s) {
        // code here
        StringBuilder answer = new StringBuilder();
        int n = s.length();

        answer.append(s.charAt(0));

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                answer.append(s.charAt(i));
            }
            else if (s.charAt(i) == s.charAt(i - 1)) {
                if (s.charAt(i) == answer.charAt(0)) break;
                answer.append(s.charAt(i));
            }
            else break;
        }

        StringBuilder temp = new StringBuilder(answer);

        answer.append(temp.reverse());

        return answer.toString();
    }
}

