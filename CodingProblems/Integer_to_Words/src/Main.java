// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            long n = Long.parseLong(br.readLine().trim());

            String ans = new Solution().convertToWords(n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private String[] one = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight "
    , "nine ", "ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen "
    , "nineteen "};
    private String[] ten = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
    "ninety "};
    final int crore = 10000000, lakh = 100000, thousand = 1000, hundred = 100;

    private String convertToWordsUtil(long n, String s) {
        String res = "";

        if (n > 19) res += ten[(int)n / 10] + one[(int)n % 10];
        else res += one[(int)n];

        if (n > 0) res += s;

        return res;
    }

    String convertToWords(long n) {
        // code here
        String res = "";

        res += convertToWordsUtil(n / crore, "crore ");

        res += convertToWordsUtil((n / lakh) % 100, "lakh ");

        res += convertToWordsUtil((n / thousand) % 100, "thousand ");

        res += convertToWordsUtil((n / hundred) % 10, "hundred ");

        if (n > 100 && n % 100 != 0) res += "and ";

        res += convertToWordsUtil(n % 100, "");

        return res;
    }
}
