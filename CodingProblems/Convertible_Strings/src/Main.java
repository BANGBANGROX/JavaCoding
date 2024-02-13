//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray {
    public static String[] input(BufferedReader br) throws IOException {
        return br.readLine().trim().split(" ");
    }
}



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());


            String[] A1 = StringArray.input(br);


            String[] A2 = StringArray.input(br);

            Solution obj = new Solution();
            System.out.println(obj.CompatibleStrings(N, A1, A2));
        }
    }
}

// } Driver Code Ends



class Solution {
    private int calculateGCD(int a, int b) {
        if (b == 0) return a;

        return calculateGCD(b, a % b);
    }

    public ArrayList<Integer> CompatibleStrings(int n, String[] words1, String[] words2) {
        // code here
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> frequencyDifferences = new ArrayList<>();
            String word1 = words1[i];
            String word2 = words2[i];
            int[] frequencyOfWord1 = new int[26];
            int[] frequencyOfWord2 = new int[26];
            int ptr1 = 0;
            int ptr2 = 0;
            for (char ch : word1.toCharArray()) {
                ++frequencyOfWord1[ch - 'a'];
            }
            for (char ch : word2.toCharArray()) {
                ++frequencyOfWord2[ch - 'a'];
            }
            while (ptr2 < 25) {
                ptr1 += frequencyOfWord1[ptr2];
                if (ptr1 < frequencyOfWord2[ptr2]) {
                    break;
                } else {
                    ptr1 -= frequencyOfWord2[ptr2];
                }
                if (ptr1 > 0) {
                    frequencyDifferences.add(ptr1);
                }
                ++ptr2;
            }
            if (ptr2 < 25 || (ptr1 + frequencyOfWord1[ptr2] != frequencyOfWord2[ptr2])) {
                answer.add(0);
            } else {
                if (frequencyDifferences.isEmpty()) {
                    answer.add(1);
                } else {
                    int gcd = frequencyDifferences.get(0);
                    for (int j = 1; j < frequencyDifferences.size(); ++j) {
                        gcd = calculateGCD(gcd, frequencyDifferences.get(j));
                    }
                    answer.add(gcd == 1 ? 0 : 1);
                }
            }
        }

        return answer;
    }
}

