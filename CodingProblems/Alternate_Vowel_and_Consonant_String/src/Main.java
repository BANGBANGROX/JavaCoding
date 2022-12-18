//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();

            Solution ob = new Solution();
            String ans = ob.rearrange(S);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String rearrange(String s) {
        StringBuilder consonants = new StringBuilder();
        StringBuilder vowels = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels.append(ch);
            } else {
                consonants.append(ch);
            }
        }

        int len1 = consonants.length();
        int len2 = vowels.length();

        if (Math.abs(len1 - len2) > 1) return "-1";

        char[] temp1 = consonants.toString().toCharArray();
        char[] temp2 = vowels.toString().toCharArray();

        Arrays.sort(temp1);
        Arrays.sort(temp2);

        consonants = new StringBuilder(String.valueOf(temp1));
        vowels = new StringBuilder(String.valueOf(temp2));

        int i = 0;
        int j = 0;
        boolean start = false;
        StringBuilder ans = new StringBuilder();

        if (len1 > len2) {
            ans.append(consonants.charAt(i));
            ++i;
        } else if (len2 > len1) {
            ans.append(vowels.charAt(j));
            ++j;
            start = true;
        } else {
            if (consonants.charAt(0) > vowels.charAt(0)) {
                ans.append(vowels.charAt(j));
                ++j;
                start = true;
            } else {
                ans.append(consonants.charAt(i));
                ++i;
            }
        }

        while (i < len1 && j < len2) {
            if (start) {
                ans.append(consonants.charAt(i));
                ++i;
            } else {
                ans.append(vowels.charAt(j));
                ++j;
            }
            start = !start;
        }

        if (i < len1) {
            ans.append(consonants.charAt(i));
        } else if (j < len2) {
            ans.append(vowels.charAt(j));
            ++j;
        }

        return ans.toString();
    }
}