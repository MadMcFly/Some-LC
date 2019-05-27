class Demo264_Ugly_Number_II {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int i1 = 0, i2 = 0, i3 = 0;
        int f1 = 2, f2 = 3, f3 = 5;
        
        nums[0] = 1;
        int min = 0;
        for(int i = 1; i < n; i++) {
            min = Math.min(Math.min(f1, f2), f3);
            nums[i] = min;
            if(min == f1) {
                f1 = 2 * nums[++i1];
            }
            if(min == f2) {
                f2 = 3 * nums[++i2];
            }
            if(min == f3) {
                f3 = 5 * nums[++i3];
            }
            System.out.println(f1 + " " + f2 + " " + f3);
        }
        // System.out.println(Arrays.toString(nums));
        return nums[n -1];
    }
}