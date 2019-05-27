class Demo84_Largest_Rectangle_in_Histogram {
    public static void main(String[] args) {
        
    }
}

class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)
            return 0;
        int res = 0;
        // int[] areas = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            int width = 1;
            int j = i - 1;
            while(j >= 0 && heights[j] >= heights[i]) {
                width++;
                j--;
            }
            j = i + 1;
            while(j < heights.length && heights[j] >= heights[i]) {
                width++;
                j++;
            }
            int temp = heights[i] * width;
            // areas[i] = temp;
            res = res > temp ? res : temp;
        }
        // System.out.println(Arrays.toString(areas));
        return res;
    }
}

class Solution_84_Better {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        
        int res = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        left[0] = -1;
        right[heights.length - 1] = heights.length;
        
        for(int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }
        
        for(int i = heights.length - 2; i > -1; i--) {
            int p = i + 1;
            while(p < heights.length && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
        }
        
        for(int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]); 
        }
        
        return res;
    }
}