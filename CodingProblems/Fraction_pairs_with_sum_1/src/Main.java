//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());


            int[] numerator = IntArray.input(br, n);


            int[] denominator = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return calculateGCD(b, a % b);
    }

    public int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        HashMap<Integer, ArrayList<Integer>> denominatorNumeratorsMapping = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            int gcd = calculateGCD(numerator[i], denominator[i]);
            numerator[i] /= gcd;
            denominator[i] /= gcd;
            if (numerator[i] > denominator[i]) continue;
            denominatorNumeratorsMapping.computeIfAbsent(denominator[i],
                    k -> new ArrayList<>()).add(numerator[i]);
        }

        for (int den : denominatorNumeratorsMapping.keySet()) {
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int num : denominatorNumeratorsMapping.get(den)) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
            for (int num : denominatorNumeratorsMapping.get(den)) {
                if (!count.containsKey(num)) {
                    continue;
                }
                int req = den - num;
                if (!count.containsKey(req)) {
                    continue;
                }
                int x = count.get(num);
                int y = count.get(req);
                if (req == num) {
                    answer += (x * (x - 1) / 2);
                }
                else {
                    answer += x * y;
                }
                count.remove(num);
            }
        }

        return answer;
    }
}

