class Demo404_Sum_of_Left_Leaves {
	public static void main(String[] args) {
		
	}
}

class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
        	return 0;
        
        return dfs(root, "", 0);
    }

    private int dfs(TreeNode curr, String location, int res) {
    	if(curr.left == null && curr.right == null) {
    		if("left".equals(location))
    			return res + curr.val;
    		else
    			return res;
    	}

    	if(curr.left != null) {
    		res = res + dfs(curr.left, "left", res);
    	}
    	if(curr.right != null) {
    		res = res + dfs(curr.right, "", res);
    	}

    	return res;
    }
}