import java.util.List;
import java.util.ArrayList;

class Demo_841_Keys_and_Rooms {
	public static void main(String[] args) {
		
	}
}

class Solution_841 {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        if (size <= 1) 
        	return true;

        boolean[] res = new boolean[size];
        res[0] = true;
        dfs(rooms, 0, res);

        for (Boolean b : res) {
        	if(!b)
        		return false;
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int index, boolean[] res) {
    	List<Integer> temp = rooms.get(index);
    	for (Integer i   : temp) {
    		if(i < res.length) {
    			if(!res[i]) {
    				res[i] = true;
    				dfs(rooms, i, res);
    			}
    		}	
    	}
    }
}