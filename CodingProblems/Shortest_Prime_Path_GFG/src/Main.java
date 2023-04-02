//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution {
    private boolean[] buildSieve() {
        final int MAX_SIZE = 1_000_00;
        boolean[] prime = new boolean[MAX_SIZE];

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i < MAX_SIZE; ++i) {
            if (prime[i]) {
                for (int j = 2 * i; j < MAX_SIZE; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public int solve(int num1, int num2) {
        //code here

        if (num1 == num2) return 0;

        final int MAX_SIZE = 1_000_00;
        boolean[] visited = new boolean[MAX_SIZE];
        boolean[] prime = buildSieve();
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;

        q.add(num1);
        visited[num1] = true;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                assert q.peek() != null;
                int num = q.poll();
                String sNum = String.valueOf(num);
                for (int pos = 0; pos < sNum.length(); ++pos) {
                    for (int dig = (pos > 0 ? 0 : 1); dig < 10; ++dig) {
                        String next = sNum.substring(0, pos) + dig + sNum.substring(pos + 1);
                        int nextNum = Integer.parseInt(next);
                        if (prime[nextNum] && !visited[nextNum]) {
                            if (nextNum == num2) return ans + 1;
                            visited[nextNum] = true;
                            q.add(nextNum);
                        }
                    }
                }
            }
            ++ans;
        }

        return -1;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            int Num1 = Integer.parseInt(input_line[0]);
            int Num2 = Integer.parseInt(input_line[1]);

            Solution ob = new Solution();
            System.out.println(ob.solve(Num1, Num2));
        }
    }
}
// } Driver Code Ends