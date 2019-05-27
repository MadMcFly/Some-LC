import java.util.HashMap;

public class Demo437_Path_Sum_III {
	public static void main(String[] args) {
		
	}
}

//hashmap-->one traverse
class Solution_437 {
	public int pathSum(TreeNode root, int sum) {
        // int res = 0;
        return findSum(root, sum);
    }

    public int findSum(TreeNode root, int sum) {
    	int res = 0;
    	if(root == null)
    		return res;

    	res += dfs(root, sum);

    	if(root.left != null)
    		res += findSum(root.left, sum);

    	if(root.right != null)
    		res += findSum(root.right, sum);

    	return res;
    }

    public int dfs(TreeNode root, int sum) {
    	int mid = 0;
    	if(root == null)
    		return mid;

    	if(root.val == sum) {
            mid++;
            System.out.println(root.val);
    		// return mid;
        }
    		

    	if(root.left != null)
    		mid += dfs(root.left, sum - root.val);

    	if(root.right != null)
    		mid += dfs(root.right, sum - root.val);

    	return mid;
    }
}

class Solution_113_Better {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(sum, 1);

        int res = 0;
    	if(root == null)
    		return res;

    	res += dfs(root, sum, hm);

    	return res;
    }

    public int dfs(TreeNode root, int sum, HashMap<Integer, Integer> hm) {
    	int mid = 0;
    	if(root == null)
    		return mid;

    	HashMap<Integer, Integer> hm1 = new HashMap<>();
        hm1.put(sum, 1);
        
        
    	for(Integer key: hm.keySet()) {
            hm1.put(key - root.val, hm1.getOrDefault(key - root.val, 0) + hm.get(key));
        }
    	// System.out.println(hm);	
    	// System.out.println(root.val);
    	//  System.out.println(hm1);
        
    	if(hm.containsKey(root.val)) {
    		mid = hm.get(root.val);
            // if(root.val != sum &&hm1.containsKey(root.val))
            //     if(hm1.get(root.val) == 1)
            //         hm1.remove(root.val);
            //     else
            //         hm1.put(root.val, hm1.get(root.val));
            // System.out.println(hm1);
      	}

    	if(root.left != null)
    		mid += dfs(root.left, sum, new HashMap<Integer, Integer>(hm1));

    	if(root.right != null)
    		mid += dfs(root.right, sum, new HashMap<Integer, Integer>(hm1));

    	return mid;
    }
}