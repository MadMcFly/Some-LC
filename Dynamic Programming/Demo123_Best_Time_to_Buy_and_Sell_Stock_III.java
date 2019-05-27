class Demo123_Best_Time_to_Buy_and_Sell_Stock_III {
	public static void main(String[] args) {
		
	}
}

class Solution_123 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        
        int lo = prices[0];
        int hi = lo;
        int res1 = 0, res2 = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > hi) {
                hi = prices[i];
            }else if(prices[i] < lo) {
                lo = prices[i];
                hi = lo;
            }
        }
        return res1 + res2;
    }
}