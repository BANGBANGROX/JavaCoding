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
            String[] s = new String[N];
            for (int i = 0; i < N; i++) s[i] = read.readLine();
            Solution ob = new Solution();
            alphanumeric[] ans = ob.sortedStrings(s);
            for (alphanumeric an : ans) System.out.println(an.name + " " + an.count);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class alphanumeric {
    public String name;
    public int count;

    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
}

class Solution {
    alphanumeric[] sortedStrings(String[] strs) {
        HashMap<String, Integer> count = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (String s : strs) {
            if (!count.containsKey(s)) {
                list.add(s);
                count.put(s, 0);
            }
            count.put(s, count.get(s) + 1);
        }

        list.sort(String::compareTo);

        alphanumeric[] ans = new alphanumeric[list.size()];

        for (int i = 0; i < list.size(); ++i) {
            ans[i] = new alphanumeric(list.get(i), count.get(list.get(i)));
        }

        return ans;
    }
}