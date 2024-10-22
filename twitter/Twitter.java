import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Twitter {
    // ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet",
    // "postTweet","postTweet","postTweet","postTweet","postTweet","postTweet",
    // "postTweet","postTweet","postTweet","postTweet","postTweet","postTweet",
    // "postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed",
    // "follow","getNewsFeed","unfollow","getNewsFeed"]
    // [],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],
    // [2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],
    // [2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],
    // [2,211],[1],[1,2],[1],[1,2],[1]
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        // [1],[1,2],[1],[1,2],[1]
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.getNewsFeed(1);
        // twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        // twitter.getNewsFeed(1); // User 1's news feed should return a list with 1
        // tweet id -> [5]. return [5]
        // twitter.follow(1, 2); // User 1 follows user 2.
        // twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        // twitter.getNewsFeed(1); // User 1's news feed should return a list with 2
        // tweet ids -> [6, 5]. Tweet id
        // // 6 should precede tweet id 5 because it is posted after tweet id 5.
        // twitter.unfollow(1, 2); // User 1 unfollows user 2.
        // twitter.getNewsFeed(1); // User 1's news feed should return a list with 1
        // tweet id -> [5], since user 1
        // is no longer following user 2.
    }

    private static HashMap<Integer, HashSet<Integer>> userFriendsMap;
    private static List<int[]> posts;

    public Twitter() {
        userFriendsMap = new HashMap<>();
        posts = new ArrayList<>();
    }

    public static void postTweet(int userId, int tweetId) {
        posts.add(new int[] { userId, tweetId });
    }

    public static List<Integer> getNewsFeed(int userId) {
        int len = posts.size();
        List<Integer> result = new ArrayList<>();
        int stopper = Math.max(len - 10, 0);
        // for (int i = len - 1; i >= stopper; i--) {
        for (int i = len - 1; i >= 0; i--) {
            int[] curr = posts.get(i);
            if (curr[0] == userId) {
                result.add(curr[1]);
            } else {
                if (userFriendsMap.containsKey(userId)) {
                    HashSet<Integer> friends = userFriendsMap.get(userId);
                    if (friends.contains(curr[0])) {
                        result.add(curr[1]);
                    }
                }
            }
            if (result.size() == 10) {
                break;
            }
        }
        return result;
    }

    public static void follow(int followerId, int followeeId) {
        if (userFriendsMap.containsKey(followerId)) {
            HashSet<Integer> friends = userFriendsMap.get(followerId);
            if (!friends.contains(followeeId)) {
                friends.add(followeeId);
                userFriendsMap.put(followerId, friends);
            }
        } else {
            HashSet<Integer> friends = new HashSet<>();
            friends.add(followeeId);
            userFriendsMap.put(followerId, friends);
        }
    }

    public static void unfollow(int followerId, int followeeId) {
        if (userFriendsMap.containsKey(followerId)) {
            HashSet<Integer> friends = userFriendsMap.get(followerId);
            if (friends.contains(followeeId)) {
                friends.remove(followeeId);
                userFriendsMap.put(followerId, friends);
            }
        }
    }
}
