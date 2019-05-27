class Demo714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
	public static void main(String[] args) {
		
	}
}

class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
     	if(prices.length <= 1)
     		return 0;
     	int lo = prices[0];
     	int hi = lo;
     	int index = 1;
     	int res = 0;
     	while(index < prices.length) {
     		if(prices[index] > lo) {
     			if(prices[index] >= hi) {
     				hi = prices[index];
     			}
     		}
     	}

     	return res;  
    }
}