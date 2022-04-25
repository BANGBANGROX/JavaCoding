import java.util.ArrayList;

class TopVotedCandidate {
    private final ArrayList<Integer> mostVoted;
    private final ArrayList<Integer> timeQuantum;

    public TopVotedCandidate(int[] persons, int[] times) {
        mostVoted = new ArrayList<>();
        timeQuantum = new ArrayList<>();
        int n = persons.length;
        int[] votes = new int[n];
        int leader = 0;

        for (int i = 0; i < n; ++i) {
            int person = persons[i];
            int time = times[i];
            ++votes[person];
            if (votes[person] > votes[leader]) {
                leader = person;
            }
            mostVoted.add(leader);
            timeQuantum.add(time);
        }
    }

    public int q(int t) {
        int n = mostVoted.size();
        int ans = 0;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (timeQuantum.get(mid) <= t) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return mostVoted.get(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};

        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);

        System.out.println(topVotedCandidate.q(3)); // return 0, At time 3, the votes are [0], and 0 is leading.
        System.out.println(topVotedCandidate.q(12)); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
        System.out.println(topVotedCandidate.q(25)); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
        System.out.println(topVotedCandidate.q(15)); // return 0
        System.out.println(topVotedCandidate.q(24)); // return 0
        System.out.println(topVotedCandidate.q(8)); // return 1
    }
}
