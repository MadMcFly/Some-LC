public class Demo_367_Valid_Perfect_Square {
    public static void main(String[] args) {
        System.out.println(new Solution_367().isPerfectSquare(16));
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
Memory Usage: 31.8 MB, less than 100.00% of Java online submissions for Valid Perfect Square.
*/

class Solution_367 {
     public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
    
        long i = num / 2;
        long s = 0;
        int low = 0;
        int high = num;
        while(true) {
            // System.out.println(i);
            
            s = i * i;
            
            if(s == num)
               return true;
            else if(s < num){
                low = (int) i;
                i = (high - low) / 2 + low;
            }
                
            else {
                high = (int) i;
                
                i = (high - low) / 2 + low;
            }
            
            if(high - low <= 1)
                return false; 
        }
    }
}