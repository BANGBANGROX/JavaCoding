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

            int N;
            N = Integer.parseInt(br.readLine());


            String S;
            S = br.readLine();

            Solution obj = new Solution();
            long res = obj.greatCount(N, S);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private long merge(int[] prefixArray, int left, int mid, int right) {
        int[] auxiliaryArray = new int[right - left + 1];
        long result = 0;
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (prefixArray[i] <= prefixArray[j]) {
                auxiliaryArray[k] = prefixArray[i];
                ++i;
            }
            else {
                auxiliaryArray[k] = prefixArray[j];
                ++j;
                result += (mid - i + 1);
            }
            ++k;
        }

        while (i <= mid) {
            auxiliaryArray[k] = prefixArray[i];
            ++i;
            ++k;
        }

        while (j <= right) {
            auxiliaryArray[k] = prefixArray[j];
            ++j;
            ++k;
        }

        k = 0;
        i = left;

        while (i <= right) {
            prefixArray[i] = auxiliaryArray[k];
            ++i;
            ++k;
        }

        return result;
    }

    private long countInversions(int[] prefixArray, int left, int right) {
        long result = 0;

        if (left < right) {
            int mid = (left + ((right - left) >> 1));
            result += countInversions(prefixArray, left, mid);
            result += countInversions(prefixArray, mid + 1, right);
            result += merge(prefixArray, left, mid, right);
        }

        return result;
    }

    private void reverse(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            ++l;
            --r;
        }
    }

    public long greatCount(int n, String s) {
        // code here
        int[] prefixArray = new int[n];
        long answer = 0;

        prefixArray[0] = s.charAt(0) == '0' ? -1 : 1;

        if (prefixArray[0] > 0) {
            ++answer;
        }

        for (int i = 1; i < n; ++i) {
            prefixArray[i] = prefixArray[i - 1] + (s.charAt(i) == '0' ? -1 : 1);
            if (prefixArray[i] > 0) {
                ++answer;
            }
        }

        reverse(prefixArray);
        answer += countInversions(prefixArray, 0, n - 1);

        return answer;
    }
}


