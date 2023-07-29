import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] requiredSkills, List<List<String>> people) {
        int m = requiredSkills.length;
        int n = people.size();
        int[] peopleSkillMask = new int[n];
        long[] dp = new long[(1 << m)];
        HashMap<String, Integer> skillId = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            skillId.put(requiredSkills[i], i);
        }

        for (int i = 0; i < n; ++i) {
            for (String skill : people.get(i)) {
                peopleSkillMask[i] |= (1 << (skillId.get(skill)));
            }
        }

        Arrays.fill(dp, (1L << n) - 1);
        dp[0] = 0;

        for (int skillMask = 1; skillMask < (1 << m); ++skillMask) {
            for (int i = 0; i < n; ++i) {
                int smallerMask = skillMask & ~peopleSkillMask[i];
                if (smallerMask != skillMask) {
                    long peopleMask = dp[smallerMask] | (1L << i);
                    if (Long.bitCount(peopleMask) < Long.bitCount(dp[skillMask])) {
                        dp[skillMask] = peopleMask;
                    }
                }
            }
        }

        long answerMask = dp[(1 << m) - 1];
        int[] answer = new int[Long.bitCount(answerMask)];
        int ptr = 0;

        for (int i = 0; i < n; ++i) {
            if ((answerMask & (1L << i)) > 0) {
                answer[ptr] = i;
                ++ptr;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] requiredSkills = new String[m];
            for (int i = 0; i < m; ++i) {
                requiredSkills[i] = sc.next();
            }
            int n = sc.nextInt();
            List<List<String>> people = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int cnt = sc.nextInt();
                List<String> skills = new ArrayList<>();
                for (int j = 0; j < cnt; ++j) {
                    String skill = sc.next();
                    skills.add(skill);
                }
                people.add(new ArrayList<>(skills));
            }

            Solution solution = new Solution();
            int[] answer = solution.smallestSufficientTeam(requiredSkills, people);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
