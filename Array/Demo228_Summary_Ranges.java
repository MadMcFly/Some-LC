class Demo228_Summary_Ranges {
	public static void main(String[] args) {
		
	}
}

class Solution_228 {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        int left = 0;
        int right = 0;
        while(i < nums.length) {
            String s = new String();
            if(i == nums.length - 1) {
                s = "" + nums[i];
                res.add(s);
                break;
            }
                
            left = i;
            while(i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            right = i;
            
            
            if(left != right) {
                s = "" + nums[left] + "->" + nums[right];
            }else {
                s = "" + nums[left];
            }
            res.add(s);
            i++;
        }
        return res;
    }
}