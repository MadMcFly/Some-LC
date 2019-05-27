import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Demo113_Path_Sum_II {
	public static void main(String[] args) {
		
	}
}

class Solution_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new  ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        dfs(root, sum, res, mid);

        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> mid) {
    	if(root == null)
            return;
        mid.add(root.val);
    	if(root.left == null && root.right == null && root.val == sum) {
    		// mid.add(root.val);
    		res.add(new ArrayList<Integer>(mid));
    	}
    	
    	if(root.left != null) {
    		// mid.add(root.val);
    		dfs(root.left, sum - root.val, res, mid);
    	}
    	
    	if(root.right != null) {
    		// mid.add(root.val);
    		dfs(root.right, sum - root.val, res, mid);
    	}
        
        mid.remove(mid.size() - 1);
    }
}

