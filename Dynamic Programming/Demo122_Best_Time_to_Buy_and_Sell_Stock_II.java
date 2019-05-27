class Demo122_Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int lo = prices[0];
        int hi = lo;
        // int index = 0;
        int res = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < lo) {
                lo = prices[i];
                hi = lo;
            }else if(prices[i] > hi){
                int tmp = hi;
                hi = prices[i];
                res += hi - tmp;
            }else {
                lo = prices[i];
                hi = lo;
            }
        }
        return res;
    }
}