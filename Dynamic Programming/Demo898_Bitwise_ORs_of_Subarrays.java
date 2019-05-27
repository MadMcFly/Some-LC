import java.util.ArrayList;
import java.util.HashSet;

public class Demo898_Bitwise_ORs_of_Subarrays {
	public static void main(String[] args) {
		System.out.println(1 | 2);
	}
}

class Solution_898 {									//time limit!
    public int subarrayBitwiseORs(int[] A) {
    	ArrayList<Integer> list = new ArrayList<>();
    	HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < A.length; i++) {
        	list.add(A[i]);
            int size = list.size();
        	for(int j = 0; j < i; j++) {
        		list.add(A[i] | list.get(size - 2 - j));
        	}
        }
        System.out.println(list);
        for(Integer i : list)
        	hs.add(i);

    	return hs.size();
    }
}