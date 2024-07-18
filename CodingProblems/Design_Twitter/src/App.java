import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    private final Map<Integer, Set<Integer>> userFollowers;
    private final Map<Integer, Set<Integer>> userTweets;
    private final Map<Integer, Integer> tweetAndTimestamp;
    private int currentTimestamp;
    private final int FEED_SIZE = 10;

    public Twitter() {
        userFollowers = new HashMap<>();
        userTweets = new HashMap<>();
        tweetAndTimestamp = new HashMap<>();
        currentTimestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new HashSet<>()).add(tweetId);
        tweetAndTimestamp.put(tweetId, currentTimestamp);
        ++currentTimestamp;
    }

    private void computeFeed(PriorityQueue<Integer> pq, Set<Integer> tweeetIds) {
        for (int tweetId : tweeetIds) {
            if (pq.size() < FEED_SIZE) {
                pq.add(tweetId);
            } else {
                int topTweetId = pq.poll();
                if (tweetAndTimestamp.get(topTweetId) < tweetAndTimestamp.get(tweetId)) {
                    pq.add(tweetId);
                } else {
                    pq.add(topTweetId);
                }
            }
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> tweetAndTimestamp.get(a)));
        List<Integer> answer = new ArrayList<>();
        
        // Add all user posts to answer
        computeFeed(pq, userTweets.getOrDefault(userId, new HashSet<>()));

        // Iterate over all followers and add their tweets
        for (int followerId : userFollowers.getOrDefault(userId, new HashSet<>())) {
            computeFeed(pq, userTweets.getOrDefault(followerId, new HashSet<>()));
        }
        
        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }

        Collections.reverse(answer);

        return answer;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowers.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowers.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class App {
    public static void main(String[] args) throws Exception {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 1);
        twitter.postTweet(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 3);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
