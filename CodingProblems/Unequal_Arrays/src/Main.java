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

            int N;
            N = Integer.parseInt(br.readLine());


            int[] A = IntArray.input(br, N);


            int[] B = IntArray.input(br, N);

            Solution obj = new Solution();
            long res = obj.solve(N, A, B);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public long solve(int n, int[] nums1, int[] nums2) {
        // code here
        ArrayList<Integer> oddNumbersFromNums1 = new ArrayList<>();
        ArrayList<Integer> evenNumbersFromNums1 = new ArrayList<>();
        ArrayList<Integer> oddNumbersFromNums2 = new ArrayList<>();
        ArrayList<Integer> evenNumbersFromNums2 = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0; i < n; ++i) {
            if (nums1[i] % 2 == 0) {
                evenNumbersFromNums1.add(nums1[i]);
            }
            else {
                oddNumbersFromNums1.add(nums1[i]);
            }
            if (nums2[i] % 2 == 0) {
                evenNumbersFromNums2.add(nums2[i]);
            }
            else {
                oddNumbersFromNums2.add(nums2[i]);
            }
        }

        if (evenNumbersFromNums1.size() != evenNumbersFromNums2.size())
            return -1;

        int oddSize = oddNumbersFromNums1.size();
        int evenSize = evenNumbersFromNums1.size();
        long differenceSum = 0;
        long oddResult = 0;
        long evenResult = 0;

        for (int i = 0; i < oddSize; ++i) {
            int difference = oddNumbersFromNums1.get(i) - oddNumbersFromNums2.get(i);
            differenceSum += difference;
            if (difference > 0) {
                oddResult += difference / 2;
            }
        }

        for (int i = 0; i < evenSize; ++i) {
            int difference = evenNumbersFromNums1.get(i) - evenNumbersFromNums2.get(i);
            differenceSum += difference;
            if (difference > 0) {
                evenResult += difference / 2;
            }
        }

        return differenceSum == 0 ? oddResult + evenResult : -1;
    }
}

