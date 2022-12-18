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
            String[] S = read.readLine().split(" ");
            Solution ob = new Solution();
            System.out.println(
                    ob.isItPossible(S[0], S[1], S[0].length(), S[1].length()));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int isItPossible(String s, String t, int m, int n) {
        // code here
        if (m != n) return 0;

        ArrayList<Pair> positionsOfS = new ArrayList<>();
        ArrayList<Pair> positionsOfT = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            if (s.charAt(i) != '#') {
                positionsOfS.add(new Pair(s.charAt(i), i));
            }
            if (t.charAt(i) != '#') {
                positionsOfT.add(new Pair(t.charAt(i), i));
            }
        }

        if (positionsOfS.size() != positionsOfT.size()) return 0;

        for (int i = 0; i < positionsOfS.size(); ++i) {
            if (positionsOfS.get(i).first != positionsOfT.get(i).first) return 0;
            if (positionsOfS.get(i).first == 'A') {
                if (positionsOfS.get(i).second < positionsOfT.get(i).second) return 0;
            }
            if (positionsOfS.get(i).first == 'B') {
                if (positionsOfS.get(i).second > positionsOfT.get(i).second) return 0;
            }
        }

        return 1;
    }
}