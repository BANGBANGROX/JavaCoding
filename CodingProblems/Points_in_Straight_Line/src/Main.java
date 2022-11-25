//{ Driver Code Starts
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();

            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; i++)
                x[i] = sc.nextInt();
            for (int i = 0; i < N; i++)
                y[i] = sc.nextInt();
            System.out.println(new GfG().maxPoints(x, y, N));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    private int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    public int maxPoints(int[] x, int[] y, int n) {
        // You are required to complete this method
        int ans = 1;

        for (int i = 0; i < n; ++i) {
            HashMap<ArrayList<Integer>, Integer> count = new HashMap<>();
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int numerator = y[j] - y[i];
                int denominator = x[j] - x[i];
                if (denominator == 0) {
                    ArrayList<Integer> current = new ArrayList<>(Arrays.asList(1, 0));
                    count.put(current, count.getOrDefault(current, 0) + 1);
                } else if (numerator == 0) {
                    ArrayList<Integer> current = new ArrayList<>(Arrays.asList(0, 1));
                    count.put(current, count.getOrDefault(current, 0) + 1);
                } else {
                    int g = gcd(Math.abs(numerator), Math.abs(denominator));
                    numerator /= g;
                    denominator /= g;
                    ArrayList<Integer> current = new
                            ArrayList<>(Arrays.asList(numerator, denominator));
                    count.put(current, count.getOrDefault(current, 0) + 1);
                }
            }
            for (ArrayList<Integer> c : count.keySet()) {
                ans = Math.max(ans, count.get(c) + 1);
            }
        }

        return ans;
    }
}