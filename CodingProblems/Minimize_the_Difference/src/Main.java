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

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int k;
            k = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    public int minimizeDifference(int n, int k, int[] nums) {
        // code here
        int[] prefixMaximum = new int[n];
        int[] prefixMinimum = new int[n];
        int[] suffixMaximum = new int[n];
        int[] suffixMinimum = new int[n];
        int answer = Integer.MAX_VALUE;

        prefixMaximum[0] = prefixMinimum[0] = nums[0];
        suffixMaximum[n - 1] = suffixMinimum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            prefixMaximum[i] = Math.max(prefixMaximum[i - 1], nums[i]);
            prefixMinimum[i] = Math.min(prefixMinimum[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; --i) {
            suffixMaximum[i] = Math.max(suffixMaximum[i + 1], nums[i]);
            suffixMinimum[i] = Math.min(suffixMinimum[i + 1], nums[i]);
        }

        for (int firstIndex = 0; firstIndex + k <= n; ++firstIndex) {
            int lastIndex = firstIndex + k - 1;
            int maxValue;
            int minValue;
            if (firstIndex == 0) {
                // [lastIndex + 1, n - 1]
                maxValue = suffixMaximum[lastIndex + 1];
                minValue = suffixMinimum[lastIndex + 1];
            }
            else if (lastIndex == n - 1) {
                // [0, firstIndex - 1]
                maxValue = prefixMaximum[firstIndex - 1];
                minValue = prefixMinimum[firstIndex - 1];
            }
            else {
                // [0, firstIndex - 1] + [lastIndex + 1, n - 1]
                maxValue = Math.max(prefixMaximum[firstIndex - 1], suffixMaximum[lastIndex + 1]);
                minValue = Math.min(prefixMinimum[firstIndex - 1], suffixMinimum[lastIndex + 1]);
            }
            answer = Math.min(answer, maxValue - minValue);
        }

        return answer;
    }
}

