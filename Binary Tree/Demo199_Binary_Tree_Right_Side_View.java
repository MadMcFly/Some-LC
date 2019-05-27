import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo199_Binary_Tree_Right_Side_View {
	public static void main(String[] args) {
		
	}
}

class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null)
        	return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;

        while(!queue.isEmpty()) {
        	int size = queue.size();

        	for(int i = 0; i < size; i++) {
        		curr = queue.remove();
        		if(curr.left != null)
        			queue.add(curr.left);
        		if(curr.right != null)
        			queue.add(curr.right);
        		if(i == size - 1)
        			res.add(curr.val);
        	}
        }

        return res;
    }
}