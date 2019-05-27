import java.util.Arrays;

public class Demo561_Array_Partition_I {
	public static void main(String[] args) {
		int[] arr = {1,4,3,2};
		System.out.println(new Solution_561().arrayPairSum(arr));
	}
}

class Solution_561 {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for(int i = 0; i < nums.length; i += 2)
			res += nums[i];
		return res;
	}
}