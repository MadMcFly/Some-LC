class Demo213_House_Robber_II {
	public static void main(String[] args) {
		
	}
}

class Solution_213 {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int lo, int hi) {
        
        int memo1 = nums[lo];
        int memo2 = 0;
        
        for(int i = lo + 1; i <= hi; i++) {
            int temp = memo1;
            memo1 = Math.max(memo2 + nums[i], memo1);
            memo2 = temp;
        }
        
        return memo1;
    }
}