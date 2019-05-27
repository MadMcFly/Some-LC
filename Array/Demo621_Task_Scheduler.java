import java.util.Arrays;

class Demo621_Task_Scheduler {
    public static void main(String[] args) {
        
    }
}

class Solution_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char c : tasks) {
            arr[c - 'A']++;
        }
        
        Arrays.sort(arr);
        
        int i = 25;
        while(i >= 0 && arr[i] == arr[25])
            i--;
        
        return Math.max(tasks.length, (n + 1) * (arr[25] - 1) + 25 - i);
    }
}