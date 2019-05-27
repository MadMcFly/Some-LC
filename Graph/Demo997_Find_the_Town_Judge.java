import java.util.HashMap;

class Demo997_Find_the_Town_Judge {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0)
            return 1;
        
        HashMap<Integer, Integer> res = new HashMap<>();
        int[] memo = new int[N];
        
        for(int i = 0; i < trust.length; i++) {
            res.put(trust[i][1], res.getOrDefault(trust[i][1], 0) + 1);
            memo[trust[i][0] - 1] = -1;
        }
        for(Integer k : res.keySet()) {
            if(res.get(k) == N - 1) {
                if(memo[k - 1] != -1)
                    return k;
            }
        }
        
        return -1;
    }
}