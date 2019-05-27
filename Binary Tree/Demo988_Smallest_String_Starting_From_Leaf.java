import java.util.LinkedList;

class Demo988_Smallest_String_Starting_From_Leaf {
	public static void main(String[] args) {
		int i = 0;

	}
}

class Solution_988 {
	public String smallestFromLeaf(TreeNode root) {
        String res = "";
        String temp = "";
        res = dfs(root, res, temp);
        return res;
    }

    private String dfs(TreeNode curr, String res, String temp) {
    	temp = ((char)('a' + curr.val)) + temp;
    	if(curr.left == null && curr.right == null) {
    		if("".equals(res))
    			res = temp;
            else if(res.compareTo(temp) > 0) {
    			res = temp;
    		}
            return res;
    	}

    	if(curr.left != null)
    		res = dfs(curr.left, res, temp);
    	if(curr.right != null)
    		res = dfs(curr.right, res, temp);
    	temp = temp.substring(1);
    	return res;
    }
}