import java.util.*;

class Solution {
    public List<Integer> topStudents(String[] positiveFeedback,
                                     String[] negativeFeedback, String[] report,
                                     int[] studentId, int k) {
        HashSet<String> positiveFeedbackSet = new HashSet<>();
        HashSet<String> negativeFeedbackSet = new HashSet<>();
        HashMap<Integer, Integer> scores = new HashMap<>();
        PriorityQueue<ArrayList<Integer>> pq =
                new PriorityQueue<>((a, b) -> !Objects.equals(a.get(0), b.get(0)) ?
                        a.get(0) - b.get(0) : b.get(1) - a.get(1));
        List<Integer> ans = new ArrayList<>();
        int n = studentId.length;

        Collections.addAll(positiveFeedbackSet, positiveFeedback);
        Collections.addAll(negativeFeedbackSet, negativeFeedback);

        for (int i = 0; i < n; ++i) {
            String[] feedback = report[i].split(" ");
            int id = studentId[i];
            int currentScore = 0;
            for (String s : feedback) {
                if (positiveFeedbackSet.contains(s)) currentScore += 3;
                else if (negativeFeedbackSet.contains(s)) --currentScore;
            }
            scores.put(id, currentScore);
        }

        for (int id : studentId) {
            if (pq.size() < k) {
                pq.add(new ArrayList<>(Arrays.asList(scores.get(id), id)));
            }
            else {
                ArrayList<Integer> top = pq.peek();
                int currentScore = scores.get(id);
                assert top != null;
                if (currentScore >= top.get(0)) {
                    if (currentScore > top.get(0) || id < top.get(1)) {
                        pq.poll();
                        pq.add(new ArrayList<>(Arrays.asList(currentScore, id)));
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().get(1));
        }

        Collections.reverse(ans);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] positiveFeedback = new String[m];
            for (int i = 0; i < m; ++i) {
                positiveFeedback[i] = sc.next();
            }
            String[] negativeFeedback = new String[m];
            for (int i = 0; i < m; ++i) {
                negativeFeedback[i] = sc.next();
            }
            int n = sc.nextInt();
            String[] report = new String[n];
            for (int i = 0; i < n; ++i) {
                report[i] = sc.nextLine();
            }
            int[] studentId = new int[n];
            for (int i = 0; i < n; ++i) {
                studentId[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.topStudents(positiveFeedback,
                    negativeFeedback, report, studentId, k));
        }

        sc.close();
    }
}
