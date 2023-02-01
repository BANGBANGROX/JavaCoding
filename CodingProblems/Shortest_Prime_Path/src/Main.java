//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution {
    private final boolean[] isPrime;

    Solution() {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        final int MAX_N = (int) 1e5 + 5;
        isPrime = new boolean[MAX_N + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= MAX_N; ++i) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= MAX_N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int shortestPath(int num1, int num2) {
        // Complete this function using prime array
        if (num1 == num2) return 0;

        String origin = String.valueOf(num1);
        String destination = String.valueOf(num2);
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int ans = 0;

        q.add(origin);
        visited.add(origin);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                String current = q.poll();
                assert current != null;
                for (int j = 0; j < 4; ++j) {
                    for (int dig = 0; dig < 10; ++dig) {
                        if (j == 0 && dig == 0) continue;
                        String next = current.substring(0, j) +
                                (char)(dig + '0') + current.substring(j + 1);
                        int num = Integer.parseInt(next);
                        if (isPrime[num] && !visited.contains(next)) {
                            if (next.equals(destination)) return ans + 1;
                            q.add(next);
                            visited.add(next);
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
        Solution ob = new Solution();
        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            int Num1 = Integer.parseInt(input_line[0]);
            int Num2 = Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1, Num2));
        }
    }
}
// } Driver Code Ends