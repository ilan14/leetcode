package design;

import java.util.*;

/**
 * 355. Design Twitter
 */
public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);

        List<Integer> list = twitter.getNewsFeed(1);

        System.out.println(list);
    }
}

class Twitter {
    // <follower, followeeSet>
    private HashMap<Integer, HashSet<Integer>> followMap;
    private HashMap<Integer, LinkedList<Feed>> feedMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        feedMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Feed> feedList = feedMap.computeIfAbsent(userId, k -> new LinkedList<Feed>());
        if (feedList.size() == 10) {
            feedList.removeLast();
        }
        feedList.addFirst(new Feed(tweetId, System.nanoTime()));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> follower = followMap.get(userId);
        PriorityQueue<Feed> queue = new PriorityQueue<Feed>(10, new Comparator<Feed>() {
            @Override
            public int compare(Feed o1, Feed o2) {
                return (int) (o2.time - o1.time);
            }
        });
        if (follower != null) {
            for (Integer followee : follower) {
                List<Feed> list = feedMap.get(followee);
                if (list != null) {
                    queue.addAll(list);
                }
            }
        }

        List<Feed> list = feedMap.get(userId);
        if (list != null) {
            queue.addAll(list);
        }

        int i = 0;
        List<Integer> feedList = new ArrayList<>(10);
        while (i < 10 && !queue.isEmpty()) {
            feedList.add(queue.poll().tweetId);
            i++;
        }
        return feedList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        HashSet<Integer> followeeSet = followMap.computeIfAbsent(followerId, k -> new HashSet<Integer>());
        followeeSet.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followeeSet = followMap.get(followerId);
        if (followeeSet != null) {
            followeeSet.remove(followeeId);
        }
    }
}

class Feed {
    int tweetId;
    long time;

    public Feed(int tweetId, long time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}
