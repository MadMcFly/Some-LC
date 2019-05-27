import java.util.Arrays;

public class Demo41_First_Missing_Positive {
	public static void main(String[] args) {
		
	}
}

class Solution_41 {
	public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int firstMissingPositive_mine(int[] nums) {
        int[] arr = new int[nums.length];
        
        System.out.println(Arrays.toString(arr));
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= nums.length && nums[i] >= 1) {
                arr[nums[i] - 1] = 1;
            }
        }
        
        System.out.println(Arrays.toString(arr));
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                return i + 1;
        }
        return nums.length + 1;
    }
}