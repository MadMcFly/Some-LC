import java.util.Arrays;

class Demo198_House_Robber {
	public static void main(String[] args) {
		
	}
}

class Solution_198 {
	private int[] memo;

	// RECURSIVE
	// public int rob(int[] nums) {
 //        memo = new int[nums.length];
 //        Arrays.fill(memo, -1);
 //        return rob(nums, nums.length - 1);      
 //    }

 //    private int rob(int[] nums, int i) {
 //    	if(i < 0)
 //    		return 0;
 //        if(memo[i] >= 0)
 //            return memo[i];
 //    	memo[i] = Math.max(rob(nums, i - 1), rob(nums, i - 2) + nums[i]);
 //        return memo[i];
 //    }

	public int rob(int[] nums) {
		memo = new int[nums.length + 1];
		memo[0] = 0;
		memo[1] = nums[0];

		for(int i = 2; i < memo.length; i++) {
			memo[i] = Math.max(nums[i - 1] + memo[i - 2], memo[i - 1]);
		}
		return memo[memo.length - 1];
	}
}