import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Map;

class Demo355_Design_Twitter {
	public static void main(String[] args) {
		Twitter obj = new Twitter();
		obj.postTweet(1,5);
		System.out.println(obj.getNewsFeed(1).toString());
		obj.follow(1,2);
		obj.postTweet(2, 6);
		System.out.println(obj.followInfo.toString());
		System.out.println(obj.tweetInfo.toString());
		System.out.println(obj.getNewsFeed(1).toString());
		obj.postTweet(1, 614);
		obj.postTweet(4, 127);
		
		// List<Integer> param_2 = obj.getNewsFeed(userId);
		// obj.follow(followerId,followeeId);
		obj.unfollow(1,4);
// 		List<Integer> param_2 = obj.getNewsFeed(1);
// 		System.out.println(param_2.toString());
	}
}

class Twitter {
	public HashMap<Integer, HashSet<Integer>> followInfo;
	public ArrayList<String> tweetInfo;
    /** Initialize your data structure here. */
    public Twitter() {
        followInfo = new HashMap<>();
        tweetInfo = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	String s = userId + "-" + tweetId;
        tweetInfo.add(s);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int index = tweetInfo.size() - 1;
        while(index >= 0 && count < 10) {
        	String[] arr = tweetInfo.get(index).split("-");
        	int uid = Integer.parseInt(arr[0]);
        	int tid = Integer.parseInt(arr[1]);
        	if(userId == uid) {
        		res.add(tid);
        		count++;
        	}else if(followInfo.containsKey(userId)) {
        		if(followInfo.get(userId) != null && followInfo.get(userId).contains(uid)) {
        			res.add(tid);
        			count++;
        		}
        	}
        	index--;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followInfo.containsKey(followerId)) {
        	HashSet<Integer> hs = new HashSet<>();
        	hs.add(followeeId);
        	followInfo.put(followerId, hs);
        }else {
        	followInfo.get(followerId).add(followeeId);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(followInfo.containsKey(followerId))
    		if(followInfo.get(followerId).contains(followeeId))
        		followInfo.get(followerId).remove(followeeId);
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