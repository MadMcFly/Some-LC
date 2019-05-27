public class Demo852_Peak_Index_in_a_Mountain_Array {
	public static void main(String[] args) {
		
	}
}

class Solution_852 {
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int mid = (low + high) >>> 1;
        
        while(!(A[mid] > A[mid - 1] && A[mid] > A[mid + 1])) {
            // System.out.println(low);
            // System.out.println(high);
            // System.out.println(mid);
            if(A[mid] > A[mid - 1]) {
                
                low = mid;
                mid = (high + low) >>> 1;
            }
            else {
                
                high = mid;
                mid = (high + low) >>> 1;
            }
        }
        return mid;
    }
}