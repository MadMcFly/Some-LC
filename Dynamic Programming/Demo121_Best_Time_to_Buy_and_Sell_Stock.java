class Demo121_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        
    }
}
class Solution_121 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        
        int res = 0;
        int lo = prices[0];
        int hi = lo;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > hi) {
                hi = prices[i];
                res = res > hi - lo ? res : hi - lo;
            }else if(prices[i] < lo) {
                lo = prices[i];
                hi = lo;
            }
        }
        
        return res;
    }
}