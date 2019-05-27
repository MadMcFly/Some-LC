class Demo152_Maximum_Product_Subarray {
	public static void main(String[] args) {
		
	}
}

class Solution_152 {
    public int maxProduct(int[] nums) {
        int[][] temp = new int[2][nums.length];
        
        if(nums[0] < 0)
        	temp[1][0] = nums[0];
        else
        	temp[0][0] = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
        	temp[0][i] = Math.max(Math.max(nums[i]*temp[0][i - 1], nums[i]*temp[1][i - 1]), nums[i]);
        	temp[1][i] = Math.min(Math.min(nums[i]*temp[0][i - 1], nums[i]*temp[1][i - 1]), nums[i]);
            if(temp[0][i] > res)
                res = temp[0][i];
            // System.out.println(res);
        }
        
        // System.out.println(Arrays.toString(temp[0]));
        // System.out.println(Arrays.toString(temp[1]));
        return res;
    }
}