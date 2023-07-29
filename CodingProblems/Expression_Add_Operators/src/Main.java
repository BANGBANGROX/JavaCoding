//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    private ArrayList<String> answer;
    private String s;
    private int target;
    private int n;

    private void generate(int index, long previousValue, long currentValue, String currentString) {
        if (index == n) {
            if (currentValue == target) {
                answer.add(currentString);
            }
            return;
        }

        long nextValue = 0;
        StringBuilder nextString = new StringBuilder();

        for (int i = index; i < n; ++i) {
            if (i > index && s.charAt(index) == '0') break;
            nextValue = nextValue * 10 + s.charAt(i) - '0';
            nextString.append(s.charAt(i));
            if (index == 0) {
                generate(i + 1, nextValue, nextValue, currentString + nextString);
            }
            else {
                generate(i + 1, nextValue, currentValue + nextValue,
                        currentString + "+" + nextString);
                generate(i + 1, -nextValue, currentValue - nextValue,
                        currentString + "-" + nextString);
                generate(i + 1, previousValue * nextValue,
                        currentValue - previousValue + previousValue * nextValue,
                        currentString + "*" + nextString);
            }
        }
    }

    public ArrayList<String> addOperators(String s, int target) {
        // code here
        answer = new ArrayList<>();
        this.s = s;
        this.target = target;
        n = s.length();

        generate(0, 0, 0, "");

        return answer;
    }
}
