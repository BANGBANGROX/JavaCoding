// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);

            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers);
            System.out.println(ans);
        }
    }
} // } Driver Code Ends


//User function Template for Java
class Solution
{
    private String findSuffix(String num, String target) {
        int m = num.length();
        int n = target.length();

        if (m > n) return "";

        int i = 0;

        while (i < m && num.charAt(i) == target.charAt(i)) {
            ++i;
        }

        if (i < m) return "";

        return target.substring(i);
    }

    public long countPairs(int n, int x, int numbers[]) {
        // code here
        String target = String.valueOf(x);
        long ans = 0;
        HashMap<String,Integer> count = new HashMap<>();

        for (int num : numbers) {
            String numString = String.valueOf(num);
            count.put(numString, count.getOrDefault(numString, 0) + 1);
        }

        for (int num : numbers) {
            String prefix = String.valueOf(num);
            String suffix = findSuffix(prefix, target);
            if (suffix.matches("") || !count.containsKey(suffix)) continue;
            if (prefix.matches(suffix)) {
                ans += (long)count.get(suffix) - 1;
            }
            else {
                ans += (long)count.get(suffix);
            }
        }

        return ans;
    }
} 